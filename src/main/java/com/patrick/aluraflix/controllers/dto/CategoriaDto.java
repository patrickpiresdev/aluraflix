package com.patrick.aluraflix.controllers.dto;

import com.patrick.aluraflix.models.Categoria;

public class CategoriaDto {

    private String titulo;
    private String cor;

    public CategoriaDto(Categoria categoria) {
        this.titulo = categoria.getTitulo();
        this.cor    = categoria.getCor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCor() {
        return cor;
    }
}
