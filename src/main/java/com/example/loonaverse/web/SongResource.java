package com.example.loonaverse.web;

import com.example.loonaverse.mappers.SongMapper;
import com.example.loonaverse.services.SongService;
import com.example.loonaverse.web.dtos.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "songs")
@RequiredArgsConstructor
public class SongResource {
    private final SongService songService;
    private final SongMapper songMapper;
    @GetMapping(path = "/{id}")
    public ResponseEntity<SongDTO> getSong(@PathVariable final Long id){
        return ResponseEntity.ok(songMapper.toDTO(songService.getSong(id)));
    }
    
    @GetMapping
    public ResponseEntity<List<SongDTO>> getAllSongs(){
        return ResponseEntity.ok(songMapper.toDTOList(songService.getAllSongs()));
    }
}
