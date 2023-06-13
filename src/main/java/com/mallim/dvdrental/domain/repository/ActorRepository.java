package com.mallim.dvdrental.domain.repository;

import com.mallim.dvdrental.domain.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
