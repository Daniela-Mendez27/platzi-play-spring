package com.platzi_play.domain.repository;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import org.hibernate.sql.Update;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updatemovieDto);
    void delete(Long id);
}
