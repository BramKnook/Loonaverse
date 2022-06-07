package com.example.loonaverse.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "Songs")
public class Song implements Serializable    {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "songs")
    private Set<Artist> artists;
    private String trackName;
    @Lob
    @Column(name="description", length=512)
    private String description;
    private Long duration;
    private String url;
    private String color;
    @Lob
    @Column(name="summary", length=2048)
    private String summary;
}
