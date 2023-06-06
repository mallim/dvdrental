package com.mallim.dvdrental.film.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
@Data
public class FilmDto {

    private Integer filmId;

    private String description;

    private String fulltext;

    private LocalDateTime lastUpdate;

    private Integer length;

    private String rating;

    private String releaseYear;

    private Integer rentalDuration;

    private Double rentalRate;

    private Double replacementCost;

    private List<String> specialFeatures;

    private String title;

    private String language;
}
