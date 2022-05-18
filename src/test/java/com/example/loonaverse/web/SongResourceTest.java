package com.example.loonaverse.web;

import com.example.loonaverse.domain.Song;
import com.example.loonaverse.mappers.SongMapper;
import com.example.loonaverse.services.SongService;
import com.example.loonaverse.web.dtos.SongDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SongResourceTest {

    @Mock
    private SongService songService;
    @Mock
    private SongMapper songMapper;

    @InjectMocks
    private SongResource songResource;

    @Test
    void getSong() {
        //setup
        final Song song = new Song();
        final SongDTO songDTO = new SongDTO();

        when(songService.getSong(1L)).thenReturn(song);
        when(songMapper.toDTO(song)).thenReturn(songDTO);

        //execute
        final ResponseEntity<SongDTO> result = this.songResource.getSong(1L);

        //check
        assertEquals(result.getBody(), songDTO);
    }

    @Test
    void getSongFailed() {
        //setup
        final Song song = new Song();

        when(songService.getSong(1L)).thenThrow(NoSuchElementException.class);

        //execute

        //check
        assertThrows(NoSuchElementException.class, ()-> this.songResource.getSong(1L));
    }

    @Test
    void getAllSongs() {
        //setup
        final List<Song> songs = List.of(new Song());
        final List<SongDTO> songDTOS = List.of(new SongDTO());

        when(songService.getAllSongs()).thenReturn(songs);
        when(songMapper.toDTOList(songs)).thenReturn(songDTOS);

        //execute
        final ResponseEntity<List<SongDTO>> result = this.songResource.getAllSongs();

        //check
        assertEquals(result.getBody(), songDTOS);
    }
}