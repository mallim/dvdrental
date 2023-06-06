package com.mallim.dvdrental.film.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record FilmSearchQueryDto( String title,
                                  String genre,
                                  String actor ) {

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
