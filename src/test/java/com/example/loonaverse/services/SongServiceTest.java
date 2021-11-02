package com.example.loonaverse.services;

import com.example.loonaverse.domain.Song;
import com.example.loonaverse.repositories.SongRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SongServiceTest {

    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private SongService songService;

    @Test
    void getSong() {
        //setup
        final Song song = new Song();

        when(songRepository.findById(1L)).thenReturn(Optional.of(song));

        //execute
        final Song result = this.songService.getSong(1L);

        //check
        assertEquals(result, song);
    }

    @Test
    void getAllSongs() {
    }
}