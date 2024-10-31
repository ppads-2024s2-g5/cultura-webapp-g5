package com.example.demo.entities.livro;

import com.example.demo.entities.itemCultural.ItemCultural;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LIVRO")
public class Livro extends ItemCultural{

    private int numeroDePaginas;
    private String genero;
    private String titulo;

    public Livro() {
        super();
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
