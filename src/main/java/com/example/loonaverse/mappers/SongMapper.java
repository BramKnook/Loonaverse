package com.example.loonaverse.mappers;

import com.example.loonaverse.domain.Song;
import com.example.loonaverse.web.dtos.SongDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = ArtistMapper.class)
public interface SongMapper {
    @Mapping(target = "id", source = "id")
    SongDTO toDTO(final Song song);
    List<SongDTO> toDTOList(final List<Song> songs);
}
