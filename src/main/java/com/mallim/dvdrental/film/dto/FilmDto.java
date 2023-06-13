package com.mallim.dvdrental.film.dto;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

public record FilmDto ( Integer filmId,
                        String description,
                        String fulltext,
                        LocalDateTime lastUpdate,
                        Integer length,
                        String rating,
                        Year releaseYear,
                        Integer rentalDuration,
                        Double rentalRate,
                        Double replacementCost,
                        List<String> specialFeatures,
                        String title,
                        String language){}