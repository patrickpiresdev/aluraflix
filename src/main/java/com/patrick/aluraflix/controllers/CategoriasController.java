package com.patrick.aluraflix.controllers;

import com.patrick.aluraflix.controllers.dto.CategoriaDto;
import com.patrick.aluraflix.models.Categoria;
import com.patrick.aluraflix.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping
    public List<CategoriaDto> list() {
        return categoriasRepository.findAll().stream().map(CategoriaDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> detail(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriasRepository.findById(id);
        if (categoria.isPresent()) return ResponseEntity.ok(new CategoriaDto(categoria.get()));
        return ResponseEntity.notFound().build();
    }
}
