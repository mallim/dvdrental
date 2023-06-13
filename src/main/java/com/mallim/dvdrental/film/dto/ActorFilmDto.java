package com.mallim.dvdrental.film.dto;

import com.mallim.dvdrental.domain.entity.Rating;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;

public record ActorFilmDto(
        long filmId,
        String title,
        String description,
        Year releaseYear,
        String language,
        BigDecimal rentalRate,
        BigDecimal replacementCost,
        Rating rating,
        List<String> specialFeatures)
{
}
