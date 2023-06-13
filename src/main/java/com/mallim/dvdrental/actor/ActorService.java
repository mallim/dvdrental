package com.mallim.dvdrental.actor;

import com.mallim.dvdrental.actor.dto.ActorDto;
import com.mallim.dvdrental.domain.entity.Actor;
import com.mallim.dvdrental.domain.entity.FilmActorKey;
import com.mallim.dvdrental.domain.repository.ActorRepository;
import com.mallim.dvdrental.domain.repository.FilmActorRepository;
import com.mallim.dvdrental.film.dto.ActorFilmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Objects;


@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    private final FilmActorRepository filmActorRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final ActorMapper mapper;

    public ActorDto create( final ActorDto payload ){
        if (Objects.nonNull( payload.actorId() ) ) {
            throw new OperationNotAllowedException();
        }

        return mapper.toDto( actorRepository.save( mapper.toActor(payload) ) );
    }

    public Page<ActorDto> fetchAllActors( PageRequest pageRequest ){
        return actorRepository.findAll(pageRequest).map(mapper::toDto);
    }

    public ActorDto get( Integer actorId ){
        return actorRepository.findById(actorId)
                .map(mapper::toDto)
                .orElseThrow(() -> new ActorNotFoundException(actorId));
    }

    public ActorDto modify( Integer actorId, ActorDto payload ){
        Actor actor = mapper.toActor( actorId, payload );
        actorRepository.save(actor);
        return mapper.toDto(actor);
    }

    public void delete(Integer actorId) {
        actorRepository.deleteById(actorId);
    }

    public ActorFilmDto getFilm( Integer actorId, Integer filmId ) {
        var key = FilmActorKey.builder()
                .actorId(actorId)
                .filmId(filmId)
                .build();
        return filmActorRepository.findById(key)
                .map( vo -> mapper.toActorFilmDto( vo.getFilm() ) )
                .orElseThrow(() -> new OperationNotAllowedException("The actor doesn't participate in film"));
    }

    public void deleteFilm( Integer actorId, Integer filmId ) {
        var key = FilmActorKey.builder()
                .actorId(actorId)
                .filmId(filmId)
                .build();
        filmActorRepository.deleteById( key );
    }
}
