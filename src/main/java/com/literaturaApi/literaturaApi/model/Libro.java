package com.literaturaApi.literaturaApi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    @Id
    @JsonAlias("id")
    private Long id;

    @JsonAlias("title")
    private String titulo;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "libro_autores", joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    @JsonAlias("authors")
    private List<Autor> autores;

    @JsonAlias("languages")
    private String[] idiomas;

    @JsonAlias("download_count")
    private Integer cantidadDescargas;

    public Libro() {
    }

    public Libro(Long id, String titulo, List<Autor> autores, String[] idiomas, Integer cantidadDescargas) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
        this.cantidadDescargas = cantidadDescargas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String[] idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Integer cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo +
                ", autores=" + autores.stream().map(a -> new String(a.getNombre())).toList() +
                ", idiomas=" + Arrays.toString(idiomas) + '\'' +
                ", cantidadDescargas=" + cantidadDescargas +
                '}';
    }
}
