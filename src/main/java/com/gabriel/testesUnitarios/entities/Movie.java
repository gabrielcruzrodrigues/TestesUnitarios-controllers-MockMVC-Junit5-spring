package com.gabriel.testesUnitarios.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private Long codec;
    private String title;
    private String description;

}
