package com.example.loonaverse.web;

import com.example.loonaverse.domain.Artist;
import com.example.loonaverse.domain.Song;
import com.example.loonaverse.mappers.ArtistMapper;
import com.example.loonaverse.services.ArtistService;
import com.example.loonaverse.web.dtos.ArtistDTO;
import com.example.loonaverse.web.dtos.SongDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArtistResourceTest {

    @Mock
    private ArtistService artistService;
    @Mock
    private ArtistMapper artistMapper;

    @InjectMocks
    private ArtistResource artistResource;

    @Test
    void getArtist() {
        //setup
        final Artist artist = new Artist();
        final ArtistDTO artistDTO = new ArtistDTO();

        when(artistService.getArtist(1L)).thenReturn(artist);
        when(artistMapper.toDTO(artist)).thenReturn(artistDTO);

        //execute
        final ResponseEntity<ArtistDTO> result = this.artistResource.getArtist(1L);

        //check
        assertEquals(result.getBody(), artistDTO);
    }

    @Test
    void getArtistFailed() {
        //setup
        final Artist artist = new Artist();

        when(artistService.getArtist(1L)).thenThrow(NoSuchElementException.class);

        //execute

        //check
        assertThrows(NoSuchElementException.class, ()-> this.artistResource.getArtist(1L));
    }


    @Test
    void getAllArtists() {
        //setup
        final List<Artist> artists = List.of(new Artist());
        final List<ArtistDTO> artistDTOS = List.of(new ArtistDTO());

        when(artistService.getAllArtists()).thenReturn(artists);
        when(artistMapper.toDTOList(artists)).thenReturn(artistDTOS);

        //execute
        final ResponseEntity<List<ArtistDTO>> result = this.artistResource.getAllArtists();

        //check
        assertEquals(result.getBody(), artistDTOS);
    }
}