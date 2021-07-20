package com.patrick.aluraflix.repositories;

import com.patrick.aluraflix.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosRepository extends JpaRepository<Video, Long> {}
