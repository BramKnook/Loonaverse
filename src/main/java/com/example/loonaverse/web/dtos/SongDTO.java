package com.example.loonaverse.web.dtos;
import lombok.Data;
import java.util.Set;

@Data
public class SongDTO {
    private Long id;
    private Set<ArtistDTO> artists;
    private String trackName;
    private String description;
    private Long duration;
    private String url;
    private String color;
    private String summary;
}
