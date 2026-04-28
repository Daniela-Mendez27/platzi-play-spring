package com.platzi_play.persistence.crup;

import com.platzi_play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrupMovieEntity extends CrudRepository <MovieEntity, Long> {

}
