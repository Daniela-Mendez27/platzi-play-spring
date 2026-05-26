package com.platzi_play.persistence.crup;

import com.platzi_play.persistence.entity.MovieEntity;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional; // Buena práctica para evitar NullPointerException

public interface CrudMovieEntity extends ListCrudRepository<MovieEntity, Long> {

    // Cambiado a 'findFirstByTitulo' y agregando el parámetro String
    MovieEntity findFirstByTitulo(String titulo);

}