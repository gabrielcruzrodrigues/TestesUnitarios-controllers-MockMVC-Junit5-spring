package com.gabriel.testesUnitarios.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.*;

import com.gabriel.testesUnitarios.Services.MovieService;
import com.gabriel.testesUnitarios.entities.Movie;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;

@WebMvcTest
public class MovieControllerTest {

    @Autowired
    private MovieController movieController;

    @MockBean
    private MovieService movieService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.movieController);
    }

    @Test
    public void shouldReturnSuccess_whenToLookForFilm() {

        when(this.movieService.findMovieByCodec("123"))
                .thenReturn(new Movie(1L, "123", "O poderoso chefão", "Sem descrição"));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/movies/{codec}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void shouldReturnNotFound_whenToLookForFilm() {
        when(this.movieService.findMovie(5L)).thenReturn(null);

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/movies/{codec}", 5L)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void shouldReturnBadRequest_whenToLookFilm() {
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/movies/{codec}", -1L)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());

        verify(this.movieService, never()).findMovie(-1L);
    }
}
