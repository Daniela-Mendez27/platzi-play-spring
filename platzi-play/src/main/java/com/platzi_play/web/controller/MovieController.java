package com.platzi_play.web.controller;

import com.platzi_play.persistence.entity.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.platzi_play.persistence.crup.CrudMovieEntity;

import java.util.List;

@RestController
public class MovieController {
    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity){
        this.crudMovieEntity = crudMovieEntity;
    }
    @GetMapping("/movies") //creación de endpoint
    public List<MovieEntity> getAll(){
        return  this.crudMovieEntity.findAll();
    }

}
