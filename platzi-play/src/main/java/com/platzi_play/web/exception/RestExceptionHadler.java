package com.platzi_play.web.exception;

import com.platzi_play.domain.exception.MovieAlredyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestControllerAdvice
public class RestExceptionHadler {

    @ExceptionHandler(MovieAlredyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlredyExistsException exception) {
        Error error = new Error("movie-alredy-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException exception) {
//        List<Error> errors = new ArrayList<>();
//
//        exception.getBindingResult().getFieldErrors().forEach((error) -> {
//            errors.add(new Error(error.getField(), error.getDefaultMessage()));
//        });
//        return ResponseEntity.badRequest().body(errors);
//    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception exception) {
        Error error =new Error("unknown-error", exception.getMessage());

        return ResponseEntity.internalServerError().body(error);


    }
}
