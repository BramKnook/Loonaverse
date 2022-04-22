package com.example.loonaverse.repositories;

import com.example.loonaverse.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
