package com.mallim.dvdrental.film;

import com.mallim.dvdrental.film.dto.FilmDto;
import com.mallim.dvdrental.film.dto.FilmSearchQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public Page<FilmDto> fetchAllFilms(@RequestParam(defaultValue = "1") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "filmId") String sortBy){
        final var of = PageRequest.of( pageNo, pageSize, Sort.by(sortBy).ascending());
        return filmService.fetchAllFilms(of);
    }

    @PostMapping("/search")
    public Page<FilmDto> searchFilms(@RequestBody FilmSearchQueryDto filmSearchQueryDto,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "20") int size){
        final var of = PageRequest.of(page, size, Sort.by("filmId").ascending());
        return filmService.searchMovies(filmSearchQueryDto, of);
    }

    @PostMapping("/genres")
    public Page<FilmDto> searchFilmsForGenre(@RequestBody FilmSearchQueryDto filmSearchQueryDto,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "20") int size){
        final var of = PageRequest.of(page, size, Sort.by("filmId").ascending());
        return filmService.searchMoviesByGenre(filmSearchQueryDto.genres(), of);
    }
}
