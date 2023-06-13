package com.mallim.dvdrental.domain.repository;

import com.mallim.dvdrental.domain.entity.FilmActor;
import com.mallim.dvdrental.domain.entity.FilmActorKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorKey>
{
}
