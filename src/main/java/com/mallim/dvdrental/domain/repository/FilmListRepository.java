package com.mallim.dvdrental.domain.repository;

import com.mallim.dvdrental.domain.entity.FilmList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmListRepository extends JpaRepository<FilmList, Long> {
}
