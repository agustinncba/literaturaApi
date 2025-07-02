package com.literaturaApi.literaturaApi.principal;

import com.literaturaApi.literaturaApi.model.Libro;
import com.literaturaApi.literaturaApi.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {
    Scanner leer = new Scanner(System.in);

    @Autowired
    LibroService libroService;

    public void mostrarMenu() {

        int opcion;
        do {
            String separador = "==============================================";
            System.out.print(separador);
            System.out.printf("%n%35s%n", "Aplicacion de Literatura");
            System.out.println(separador);
            System.out.println("""
                    1) Buscar libro por título
                    2) Listar libros registrados
                    3) Listar autores registrados
                    4) Listar autores vivos en un determinado año
                    5) Listar libros por idioma
                    6) Listar libros por idioma Paginado
                    
                    0) Salir
                    """);
            System.out.print(">> Digite la opcion: ");

            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print(">> Ingrese el nombre del titulo a buscar :");
                    String nombreLibro = leer.next();

                    Optional<Libro> libroABuscar = libroService.buscarLibroPorTitulo(nombreLibro);
                    if (libroABuscar.isPresent()) {
                        System.out.println("El Libro fue encontrado: " + libroABuscar.get());
                    } else {
                        System.out.println("El libro no existe!");
                    }
                    break;
                case 2:
                    List<Libro> libros = libroService.listarLibros();
                    libros.forEach(System.out::println);
                    break;
                default:
                    System.out.println("opcion default");
                    break;
            }
        } while (opcion != 0);
    }
}
