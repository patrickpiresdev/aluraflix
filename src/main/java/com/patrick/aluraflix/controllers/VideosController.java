package com.patrick.aluraflix.controllers;

import com.patrick.aluraflix.controllers.dto.VideoDto;
import com.patrick.aluraflix.repositories.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/videos")
public class VideosController {

    @Autowired
    private VideosRepository videosRepository;

    @GetMapping
    public List<VideoDto> list() {
        return videosRepository.findAll().stream().map(VideoDto::new).collect(Collectors.toList());
    }
}
