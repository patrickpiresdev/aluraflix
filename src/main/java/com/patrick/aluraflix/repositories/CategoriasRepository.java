package com.patrick.aluraflix.repositories;

import com.patrick.aluraflix.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {}
