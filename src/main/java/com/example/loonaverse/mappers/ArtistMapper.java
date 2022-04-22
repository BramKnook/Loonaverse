package com.example.loonaverse.mappers;
import com.example.loonaverse.domain.Artist;
import com.example.loonaverse.web.dtos.ArtistDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    @Mapping(target = "id", source = "id")
    ArtistDTO toDTO(final Artist artist);
    Set<ArtistDTO> toDTOSet(final Set<Artist> artists);
    List<ArtistDTO> toDTOList(final List<Artist> artists);
}
