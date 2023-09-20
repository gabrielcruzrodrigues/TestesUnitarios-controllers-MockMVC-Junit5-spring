package com.gabriel.testesUnitarios.controller;

import com.gabriel.testesUnitarios.Services.MovieService;
import com.gabriel.testesUnitarios.entities.Movie;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{codec}")
    public ResponseEntity<List<Movie>> findMovie(@PathVariable String codec) {
        List<Movie> movie = this.movieService.findMovieByCodec(codec);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
}
