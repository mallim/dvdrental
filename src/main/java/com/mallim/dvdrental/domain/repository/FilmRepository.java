package com.mallim.dvdrental.domain.repository;

import com.mallim.dvdrental.domain.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("""
            select distinct f from Film f \s
            join f.filmActors fa \s
            where f.title like %:title% \s
            and concat(lower(fa.actor.firstName), ' ',lower(fa.actor.lastName)) like %:actorName% \s
            """)
    Page<Film> searchMovies(String title, String actorName, PageRequest pageable);

    @Query("""
            select distinct f from Film f \s
            where lower(f.title) like %:title% \s
            """)
    Page<Film> searchMoviesForTitle(String title, PageRequest pageable);

    @Query("select f from Film f join f.filmCategories fc where fc.category.name in (:genres)")
    Page<Film> findAllForGenres(List<String> genres, PageRequest pageRequest);
}
