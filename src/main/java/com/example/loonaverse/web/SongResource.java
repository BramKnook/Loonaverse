package com.example.loonaverse.web;

import com.example.loonaverse.domain.Song;
import com.example.loonaverse.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(path = "songs")
@RequiredArgsConstructor
public class SongResource {
    private final SongService songService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Song> getSong(@PathVariable final Long id){
        return ResponseEntity.ok(songService.getSong(id));
    }
    
    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs(){
        return ResponseEntity.ok(songService.getAllSongs());
    }
}
