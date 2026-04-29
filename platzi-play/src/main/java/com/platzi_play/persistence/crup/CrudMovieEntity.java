package com.platzi_play.persistence.crup;

import com.platzi_play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;


public interface CrudMovieEntity extends ListCrudRepository<MovieEntity, Long> {

}
