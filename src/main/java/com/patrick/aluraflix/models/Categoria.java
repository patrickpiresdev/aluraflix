package com.patrick.aluraflix.models;

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

    public String getTitulo() {
        return this.titulo;
    }

    public String getCor() {
        return this.cor;
    }
}