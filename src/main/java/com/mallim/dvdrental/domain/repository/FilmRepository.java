package com.mallim.dvdrental.domain.repository;

import com.mallim.dvdrental.domain.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("ALL")
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("""
            select distinct f from Film f 
            join f.filmActors fa 
            where f.title like %:title% 
            and concat(lower(fa.actor.firstName), ' ',lower(fa.actor.lastName)) like %:actorName% 
            """)
    Page<Film> searchMovies(String title, String actorName, PageRequest pageable);

    @Query("""
            select distinct f from Film f 
            where lower(f.title) like %:title% 
            """)
    Page<Film> searchMoviesForTitle(String title, PageRequest pageable);

    @Query("select f from Film f join f.filmCategories fc where fc.category.name in (:genres)")
    Page<Film> findAllForGenres(List<String> genres, PageRequest pageRequest);

    @Query(value = """
        select f.* from film f 
        inner join film_actor fa 
        on f.film_id = fa.film_id 
        where fa.actor_id = :actorId
    """, nativeQuery = true)
    Stream<Film> findAllByActor( Integer actorId );
}
