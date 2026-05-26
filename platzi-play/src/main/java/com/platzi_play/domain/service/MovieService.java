package com.platzi_play.domain.service;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi_play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Tool("Busca todas las peliculas que exitan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return movieRepository.getAll();
    }

    public MovieDto getById(Long id) {
        return movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto) {
        return movieRepository.save(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        return movieRepository.update(id, updateMovieDto);
    }

    public void delete(Long id) {
        this.movieRepository.delete(id);
    }
}