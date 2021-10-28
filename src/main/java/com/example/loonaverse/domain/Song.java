package com.example.loonaverse.domain;

import lombok.Data;

@Data
public class Song {
    private final Long id;
    private final String trackName;
    private final String artist;
    private final String description;
    private final Long duration;
}
