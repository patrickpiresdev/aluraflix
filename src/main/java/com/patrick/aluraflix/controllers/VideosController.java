package com.patrick.aluraflix.controllers;

import com.patrick.aluraflix.controllers.dto.VideoDto;
import com.patrick.aluraflix.controllers.form.VideoForm;
import com.patrick.aluraflix.models.Video;
import com.patrick.aluraflix.repositories.VideosRepository;
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
@RequestMapping("/videos")
public class VideosController {

    @Autowired
    private VideosRepository videosRepository;

    @GetMapping
    public List<VideoDto> list() {
        return videosRepository.findAll().stream().map(VideoDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> detail(@PathVariable Long id) {
        Optional<Video> video = videosRepository.findById(id);

        return video.isPresent() ?
                ResponseEntity.ok(new VideoDto(video.get())) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VideoDto> create(@RequestBody @Valid VideoForm videoForm, UriComponentsBuilder uriBuilder) {
        Video video = videoForm.convert();
        videosRepository.save(video);

        URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Video> video = videosRepository.findById(id);

        if (video.isPresent()) {
            videosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VideoDto> update(@PathVariable Long id, @RequestBody @Valid VideoForm videoForm) {
        Optional<Video> optional = videosRepository.findById(id);

        if (optional.isPresent()) {
            Video video = optional.get();
            video.atualizar(videoForm);
            return ResponseEntity.ok(new VideoDto(video));
        }

        return ResponseEntity.notFound().build();
    }
}
