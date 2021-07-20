package com.patrick.aluraflix.controllers.dto;

import com.patrick.aluraflix.models.Video;

public class VideoDto {
    private String titulo;
    private String descricao;
    private String url;

    public VideoDto(Video video) {
        this.titulo    = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url       = video.getUrl();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }
}
