package com.mallim.dvdrental.film;

import com.mallim.dvdrental.film.dto.FilmDto;
import com.mallim.dvdrental.film.dto.FilmSearchQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<Page<FilmDto>> fetchAllFilms(
            @RequestParam(defaultValue = "1") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "filmId") String sortBy){

        final var of = PageRequest.of( pageNo, pageSize, Sort.by(sortBy).ascending());
        var result = filmService.fetchAllFilms(of);
        if (result.hasContent()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<FilmDto>>searchFilms(
            @RequestBody FilmSearchQueryDto filmSearchQueryDto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size ){

        final var of = PageRequest.of(page, size, Sort.by("filmId").ascending());
        var result = filmService.searchMovies(filmSearchQueryDto, of);
        if (result.hasContent()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/genres")
    public ResponseEntity<Page<FilmDto>> searchFilmsForGenre(
            @RequestBody FilmSearchQueryDto filmSearchQueryDto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size ){

        final var of = PageRequest.of(page, size, Sort.by("filmId").ascending());
        var result = filmService.searchMoviesByGenre(filmSearchQueryDto.genres(), of);
        if (result.hasContent()) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.noContent().build();
    }
}
