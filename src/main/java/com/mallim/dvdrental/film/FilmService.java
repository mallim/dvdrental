package com.mallim.dvdrental.film;

import com.mallim.dvdrental.domain.entity.Film;
import com.mallim.dvdrental.domain.repository.FilmRepository;
import com.mallim.dvdrental.film.dto.ActorFilmDto;
import com.mallim.dvdrental.film.dto.FilmDto;
import com.mallim.dvdrental.film.dto.FilmSearchQueryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final FilmMapper filmMapper;

    @Transactional(readOnly = true)
    public Page<FilmDto> fetchAllFilms(PageRequest pageRequest ) {
        return filmRepository.findAll(pageRequest).map(filmMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<FilmDto> searchMovies(FilmSearchQueryDto filmSearchQueryDto, PageRequest pageRequest) {
        if( filmSearchQueryDto.isValidTitle() && filmSearchQueryDto.isValidActorsName() )
            return filmRepository.searchMovies(filmSearchQueryDto.title().toLowerCase(), filmSearchQueryDto.actor().toLowerCase(), pageRequest)
                    .map(filmMapper::toDto);
        else if( filmSearchQueryDto.isValidTitle() ) {
            return filmRepository.searchMoviesForTitle(filmSearchQueryDto.title().toLowerCase(), pageRequest)
                    .map(filmMapper::toDto);
        } else if ( filmSearchQueryDto.isValidActorsName() ) {
            return filmRepository.searchMoviesForTitle(filmSearchQueryDto.actor().toLowerCase(), pageRequest)
                    .map(filmMapper::toDto);
        } else
            throw new RuntimeException("invalid request");
    }

    @Transactional(readOnly = true)
    public Page<FilmDto> searchMoviesByGenre(List<String> genres, PageRequest pageRequest ) {
        return filmRepository.findAllForGenres(genres, pageRequest).map(filmMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<Film> findAllByIds(List<Long> filmIds){
        return filmRepository.findAllById(filmIds);
    }

    @Transactional(readOnly = true)
    public List<ActorFilmDto> findFilmsByActor( Integer actorId ) {
        return filmRepository.findAllByActor( actorId )
                .map(filmMapper::toActorFilmDto)
                .collect( Collectors.toList());
    }
}
