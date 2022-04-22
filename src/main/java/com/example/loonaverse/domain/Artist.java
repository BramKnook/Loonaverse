package com.example.loonaverse.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Artists")
@EqualsAndHashCode(exclude = "songs")
@ToString(exclude = "songs")
public class Artist implements Serializable    {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Artists_Songs",
            joinColumns = {@JoinColumn(name = "artist_id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id")}
    )
    private Set<Song> songs;
    private String birthDate;
    private String color;
    private String name;
    private String subunit;
    private String info;
}
