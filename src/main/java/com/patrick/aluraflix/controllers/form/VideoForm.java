package com.patrick.aluraflix.controllers.form;

import com.patrick.aluraflix.models.Video;
import com.patrick.aluraflix.repositories.VideosRepository;

import javax.validation.constraints.NotNull;

public class VideoForm {

    @NotNull private String titulo;
    @NotNull private String descricao;
    @NotNull private String url;

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public void setUrl(String url) { this.url = url; }

    public String getTitulo() { return titulo; }

    public String getDescricao() { return descricao; }

    public String getUrl() { return url; }

    public Video convert() { return new Video(this.titulo, this.descricao, this.url); }
}
