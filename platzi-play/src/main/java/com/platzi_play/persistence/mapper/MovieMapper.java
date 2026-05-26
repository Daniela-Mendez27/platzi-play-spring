package com.platzi_play.persistence.mapper;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.persistence.entity.MovieEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDto toDto(MovieEntity entity);

    List<MovieDto> toDtos(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration(name = "toDto")
    @Mapping(source = "genre", target = "genero", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto dto);

    //  CAMBIA @InheritInverseConfiguration POR @InheritConfiguration APUNTANDO A toEntity
    @InheritConfiguration(name = "toEntity")
    void updateEntityFromDto(MovieDto dto, @MappingTarget MovieEntity entity);
}