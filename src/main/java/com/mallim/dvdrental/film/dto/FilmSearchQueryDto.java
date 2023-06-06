package com.mallim.dvdrental.film.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
@Data
public class FilmSearchQueryDto {

    private String title;

    private String genre;

    private String actor;

    public boolean isValidActorsName() {
        return Objects.nonNull( this.actor ) && ! this.actor.isEmpty();
    }

    public boolean isValidTitle() {
        return Objects.nonNull( this.title ) && ! this.title.isEmpty();
    }

    public List<String> genres() {
        return Arrays.asList( this.genre.split( "," ) );
    }
}
