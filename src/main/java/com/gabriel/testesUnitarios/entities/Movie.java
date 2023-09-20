package com.gabriel.testesUnitarios.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private Long id;
    private String codec;
    private String title;
    private String description;

}
