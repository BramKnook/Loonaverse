package com.example.loonaverse.services;

import com.example.loonaverse.domain.Artist;
import com.example.loonaverse.domain.Song;
import com.example.loonaverse.repositories.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    private ArtistService artistService;

    @Test
    void getArtist() {
        //setup
        final Artist artist = new Artist();

        when(artistRepository.findById(1L)).thenReturn(Optional.of(artist));

        //execute
        final Artist result = this.artistService.getArtist(1L);

        //check
        assertEquals(result,artist);
    }

    @Test
    void getArtistFailed() {
        //setup
        final Artist artist = new Artist();

        when(artistRepository.findById(1L)).thenReturn(Optional.empty());

        //execute

        //check
        assertThrows(NoSuchElementException.class, ()-> this.artistService.getArtist(1L));
    }

    @Test
    void getAllArtists() {
        final List<Artist> artists = List.of(new Artist());

        when(artistRepository.findAll()).thenReturn(artists);

        //execute
        final List<Artist> result = this.artistService.getAllArtists();

        //check
        assertEquals(result, artists);
    }
}