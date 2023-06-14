package com.mallim.dvdrental.actor;

import com.mallim.dvdrental.film.FilmService;
import com.mallim.dvdrental.film.dto.ActorFilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actors")
@RequiredArgsConstructor
public class ActorFilmsController
{
    private final ActorService actorService;

    private final FilmService filmService;

    @GetMapping("/{actorId}/films")
    public ResponseEntity<List<ActorFilmDto>> listActorFilms( @PathVariable final Integer actorId )
    {
        List<ActorFilmDto> films = filmService.findFilmsByActor(actorId);
        if (films.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(films);
    }

    @GetMapping("/{actorId}/films/{filmId}")
    public ActorFilmDto getActorFilm( @PathVariable final Integer actorId,
                                      @PathVariable final Integer filmId ) {
        return actorService.getFilm( actorId, filmId );
    }

    @DeleteMapping("/{actorId}/films/{filmId}")
    public ResponseEntity<?> deleteActorFilm( @PathVariable final Integer actorId,
                                              @PathVariable final Integer filmId ) {
        actorService.deleteFilm( actorId, filmId );

        return ResponseEntity.ok().build();
    }
}
