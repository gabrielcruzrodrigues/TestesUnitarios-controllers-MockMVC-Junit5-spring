package com.gabriel.testesUnitarios.controller;

import com.gabriel.testesUnitarios.Services.MovieService;
import com.gabriel.testesUnitarios.entities.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{codec}")
    public ResponseEntity<Movie> findMovie(@PathVariable Long codec) {

        if (codec < 0) {
            return ResponseEntity.badRequest().build();
        }

        Movie movie = this.movieService.findMovie(codec);


        if(movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
}
