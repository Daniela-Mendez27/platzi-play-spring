package com.platzi_play.persistence.mapper;

import com.platzi_play.domain.Genre;
import org.mapstruct.Mapper; // <--- TE FALTABA ESTA
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    @Named("stringToGenre")
    default Genre stringToGenre(String genero) {
        if (genero == null) return null;

        return switch (genero.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMADA" -> Genre.ANIMATED;
            case "TERROR" -> Genre.HORROR;
            case "CIENCIA_FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    default String genreToString(Genre genre) {
        if (genre == null) return null;

        return switch (genre) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
        };
    }
}