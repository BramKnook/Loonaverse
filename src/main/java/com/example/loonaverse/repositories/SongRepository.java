package com.example.loonaverse.repositories;

import com.example.loonaverse.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
