package com.example.loonaverse.services;

import com.example.loonaverse.domain.Song;
import com.example.loonaverse.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;

    @Transactional(readOnly = true)
    public Song getSong(final Long id){
        return songRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }
}
