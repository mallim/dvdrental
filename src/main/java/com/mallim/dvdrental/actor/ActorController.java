package com.mallim.dvdrental.actor;

import com.mallim.dvdrental.actor.dto.ActorDto;
import com.mallim.dvdrental.film.FilmService;
import com.mallim.dvdrental.film.dto.ActorFilmDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("actors")
@RequiredArgsConstructor
public class ActorController
{
    private final ActorService actorService;

    private final FilmService filmService;

    @DeleteMapping("/{actorId}/films/{filmId}")
    public ResponseEntity<?> deleteActorFilm( @PathVariable final Integer actorId,
                                              @PathVariable final Integer filmId ) {
        actorService.deleteFilm( actorId, filmId );

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{actorId}/films/{filmId}")
    public ActorFilmDto getActorFilm( @PathVariable final Integer actorId,
                                      @PathVariable final Integer filmId ) {
        return actorService.getFilm( actorId, filmId );
    }

    @GetMapping("/{actorId}/films")
    public ResponseEntity<List<ActorFilmDto>> listActorFilms( @PathVariable final Integer actorId )
    {
        List<ActorFilmDto> films = filmService.findFilmsByActor(actorId);
        if (films.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(films);
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<?> deleteActor( @PathVariable final Integer actorId )
    {
        actorService.delete( actorId );

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{actorId}")
    public ActorDto modifyActor( @PathVariable final Integer actorId,
                                 @RequestBody final ActorDto payload )
    {
        return actorService.modify( actorId, payload );
    }

    @GetMapping("/{actorId}")
    @ResponseBody
    public ActorDto getActor( @PathVariable Integer actorId ) {
        return actorService.get( actorId );
    }

    @PostMapping
    public ResponseEntity<?> createActor( @Valid @RequestBody final ActorDto payload )
    {
        ActorDto result = actorService.create( payload );

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest().path( "/{actorId}" )
                .buildAndExpand( result.actorId() ).toUri();

        return ResponseEntity.created( location ).body( result );
    }

    @GetMapping
    public ResponseEntity<Page<ActorDto>> fetchAllActors(
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "actorId") String sortBy )
    {
        final var of = PageRequest.of( pageNo, pageSize, Sort.by( sortBy ).ascending() );
        var result = actorService.fetchAllActors( of );
        if( result.hasContent() ){
            return ResponseEntity.ok().body( result );
        }
        return ResponseEntity.noContent().build();
    }
}
