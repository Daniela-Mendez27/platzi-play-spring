package com.platzi_play.web.controller;

import com.platzi_play.domain.dto.MovieDto;
import com.platzi_play.domain.dto.SuggestRequestDto;
import com.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi_play.domain.service.MovieService;
import com.platzi_play.domain.service.PlatziPlayAIService;
import dev.langchain4j.service.UserMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name= "Movies", description = "Operation about movies of PlatziPlay")

public class MovieController {
   private  final MovieService movieService;
   private final PlatziPlayAIService aiService;

   public MovieController(MovieService movieService, PlatziPlayAIService aiService) {
        this.movieService = movieService;

       this.aiService = aiService;
   }
    @GetMapping //creación de endpoint
    public ResponseEntity<List<MovieDto>> getAll(){

       return  ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener una pelicula por su identificador ",
            description = "Retorna la pelicula que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula encontrada"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no encontrada", content = @Content)
            }
    )

    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la pelicula a recuperar", example = "9") @PathVariable Long id){
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(movieDto);
    }
    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }

    @PostMapping
    public ResponseEntity <MovieDto> add(@RequestBody MovieDto movieDto){
       return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }



    @PutMapping ("/{id}")
    public ResponseEntity <MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
       return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete(@PathVariable long id){
       this.movieService.delete(id);
       return ResponseEntity.ok().build();
    }
}
