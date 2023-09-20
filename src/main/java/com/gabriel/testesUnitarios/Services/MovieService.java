package com.gabriel.testesUnitarios.Services;

import com.gabriel.testesUnitarios.entities.Movie;
import com.gabriel.testesUnitarios.exceptions.ObjectNotFoundException;
import com.gabriel.testesUnitarios.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Slf4j
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> findMovieByCodec(String codec) {
        System.out.println(codec);
        if (!containsOnlyNumbers(codec)) {
            throw new InvalidParameterException("O codec deve conter apenas numeros!");
        }
        return movieRepository.findByCodec(codec);
    }

    private boolean containsOnlyNumbers(String codec) {
        return codec.matches("[0-9]+");
    }
}
