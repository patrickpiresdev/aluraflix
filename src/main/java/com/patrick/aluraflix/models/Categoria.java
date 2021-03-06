package com.patrick.aluraflix.models;

import com.patrick.aluraflix.controllers.form.CategoriaForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String cor;

    public Categoria() {}

    public Categoria(String titulo, String cor) {
        this.titulo = titulo;
        this.cor = cor;
    }

    public String getTitulo() { return this.titulo; }

    public String getCor() { return this.cor; }

    public Long getId() { return this.id; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setCor(String cor) { this.cor = cor; }

    public void atualizar(CategoriaForm categoriaForm) {
        this.titulo = categoriaForm.getTitulo();
        this.cor    = categoriaForm.getCor();
    }
}
