package com.example.loonaverse.repositories;

import com.example.loonaverse.domain.Song;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Override
    @EntityGraph(attributePaths = {"artists"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Song>findAll();
}
