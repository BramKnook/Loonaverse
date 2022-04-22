package com.example.loonaverse.services;

import com.example.loonaverse.domain.Artist;
import com.example.loonaverse.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Transactional(readOnly = true)
    public Artist getArtist(final Long id){
        return artistRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }
}
