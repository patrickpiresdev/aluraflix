package com.patrick.aluraflix.controllers;

import com.patrick.aluraflix.controllers.dto.CategoriaDto;
import com.patrick.aluraflix.controllers.form.CategoriaForm;
import com.patrick.aluraflix.models.Categoria;
import com.patrick.aluraflix.repositories.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> create(@RequestBody @Valid CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder) {
        Categoria categoria = categoriaForm.convert();
        categoriasRepository.save(categoria);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @RequestBody @Valid CategoriaForm categoriaForm) {
        Optional<Categoria> optional = categoriasRepository.findById(id);

        if (optional.isPresent()) {
            Categoria categoria = categoriaForm.atualizar(id, categoriasRepository);
            return ResponseEntity.ok(new CategoriaDto(categoria));
        }

        return ResponseEntity.notFound().build();
    }
}
