package com.literaturaApi.literaturaApi.service;

import com.literaturaApi.literaturaApi.model.Autor;
import com.literaturaApi.literaturaApi.model.Datos;
import com.literaturaApi.literaturaApi.model.Libro;
import com.literaturaApi.literaturaApi.repository.AutorRepository;
import com.literaturaApi.literaturaApi.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibroService {
    private final String URL_BASE = "https://gutendex.com/books/";

    ConsumoApi consumoApi = new ConsumoApi();

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    ConvertirDatos convertirDatos;

    public Optional<Libro> buscarLibroPorTitulo(String nombreLibro) {
        Optional<Libro> libroExistente = libroRepository.findByTituloContainsIgnoreCase(nombreLibro);
        if (libroExistente.isPresent()) {
            System.out.println("El libro ya se encuentra en la base de datos.");
            return libroExistente;
        }

        try {
            String URL_FINAL = URL_BASE + "?search=" + URLEncoder.encode(nombreLibro, StandardCharsets.UTF_8);
            String json = consumoApi.obtenerDatos(URL_FINAL);
            Datos datos = convertirDatos.obtenerDatos(json, Datos.class);

            Optional<Libro> libroDesdeApi = datos.datosLibros().stream()
                    .filter(l -> l.getTitulo().toLowerCase().contains(nombreLibro.toLowerCase()))
                    .findFirst();

            if (libroDesdeApi.isPresent()) {
                return Optional.of(guardarLibroConAutores(libroDesdeApi.get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            System.err.println("Error al buscar en la API: " + e.getMessage());
            return Optional.empty();
        }
    }

    private Libro guardarLibroConAutores(Libro libro) {
        List<Autor> listaAutores = new ArrayList<>();
        if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
            for (Autor autorApi : libro.getAutores()) {
                Optional<Autor> autorEnDb = autorRepository.findByNombre(autorApi.getNombre());
                listaAutores.add(autorEnDb.orElseGet(() -> autorRepository.save(autorApi)));
            }
        }

        libro.setAutores(listaAutores);

        System.out.println("Guardando nuevo libro: " + libro.getTitulo());
        return libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Long cantidadLibrosPorIdioma(String idioma) {
        List<Libro> libros = listarLibros();
        return libros.stream()
                .filter(l -> l.getIdiomas().contains(idioma))
                .count();
    }

    public List<Libro> listarLibrosPorIdiomaPaginado(String idioma) {
        return listarLibros().stream()
                .filter(l -> l.getIdiomas().contains(idioma))
                .collect(Collectors.toList());
    }
}