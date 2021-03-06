package com.patrick.aluraflix.models;

import com.patrick.aluraflix.controllers.form.VideoForm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    public Video() {}

    public Video(String titulo, String descricao, String url) {
        this.titulo    = titulo;
        this.descricao = descricao;
        this.url       = url;
    }

    public Long getId() { return this.id; }

    public String getTitulo() { return titulo; }

    public String getDescricao() { return descricao; }

    public String getUrl() { return url; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setUrl(String url) { this.url = url; }

    public void atualizar(VideoForm videoForm) {
        this.titulo    = videoForm.getTitulo();
        this.descricao = videoForm.getDescricao();
        this.url       = videoForm.getUrl();
    }
}
