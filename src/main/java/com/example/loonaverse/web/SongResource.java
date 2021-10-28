package com.example.loonaverse.web;

import com.example.loonaverse.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "songs")
@RequiredArgsConstructor
public class SongResource {
    private final SongService songService;

    @GetMapping(path = "/{id}")
    public String getSong(@PathVariable final Integer id){
        return songService.getSong(id);
    }
    
    @GetMapping
    public String getAllSongs(){
        return songService.getAllSongs();
    }
}
