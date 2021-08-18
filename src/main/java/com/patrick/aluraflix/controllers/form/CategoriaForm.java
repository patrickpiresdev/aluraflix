package com.patrick.aluraflix.controllers.form;

import com.patrick.aluraflix.models.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CategoriaForm {
    private final String HEX_COLOR_PATTERN = "^#[0-9a-fA-F]{6}";

    @NotNull @NotEmpty private String titulo;
    @NotNull @NotEmpty @Pattern(regexp = HEX_COLOR_PATTERN) private String cor;

    public CategoriaForm(String titulo, String cor) {
        this.titulo = titulo;
        this.cor = cor;
    }

    public Categoria convert() { return new Categoria(titulo, cor); }
}
