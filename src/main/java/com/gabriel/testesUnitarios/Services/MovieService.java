package com.gabriel.testesUnitarios.Services;

import com.gabriel.testesUnitarios.entities.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieService {

    public Movie findMovie(Long codec) {
        if (codec > 100) {
            return null;
        }


        return new Movie(
                codec,
                "O poderoso Chefão",
                "Filme norme americano de 1972, dirigido por frances ford coppola"
        );
    }
}
