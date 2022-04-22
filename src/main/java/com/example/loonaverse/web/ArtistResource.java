package com.example.loonaverse.web;

import com.example.loonaverse.mappers.ArtistMapper;
import com.example.loonaverse.services.ArtistService;
import com.example.loonaverse.web.dtos.ArtistDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "artists")
@RequiredArgsConstructor
public class ArtistResource {
    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ArtistDTO> getArtist(@PathVariable final Long id){
        return ResponseEntity.ok(artistMapper.toDTO(artistService.getArtist(id)));
    }

    @GetMapping
    public ResponseEntity<List<ArtistDTO>> getAllArtists(){
        return ResponseEntity.ok(artistMapper.toDTOList(artistService.getAllArtists()));
    }
}