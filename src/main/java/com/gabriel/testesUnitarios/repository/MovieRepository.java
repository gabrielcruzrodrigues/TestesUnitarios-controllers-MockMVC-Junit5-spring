package com.gabriel.testesUnitarios.repository;

import com.gabriel.testesUnitarios.entities.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class MovieRepository {

    public List<Movie> findAll() {
        return listMovie();
    }

    public List<Movie> findByCodec(String codec) {
        List<Movie> movies = listMovie();
        log.info("passou");
        return movies.stream()
                .filter(Objects::nonNull)
                .filter(movie -> movie.getCodec().equals(codec))
                .collect(Collectors.toList());
    }

    private static List<Movie> listMovie() {

        return Arrays.asList(
                new Movie(1L, "456", "Jornada nas estrelas", "É um filme ..."),
                new Movie(2L, "654","StarWars", "É um filme ..."),
                new Movie(3L, "789","O poderoso chefão", "É um filme ..."),
                new Movie(4L, "987","O jogo da imitação", "É um filme ..."),
                new Movie(5L, "123","jogos vorazes", "É um filme ..."),
                new Movie(6L, "321","Circulo de fogo", "É um filme ..."),
                new Movie(7L, "147","Circulo de fogo 2", "É um filme ..."),
                new Movie(8L, "852","A rede social", "É um filme ..."),
                new Movie(9L, "963","2012", "É um filme ..."),
                new Movie(10L, "159","InterEstelar", "É um filme ...")
        );
    }
}
