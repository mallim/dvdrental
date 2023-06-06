package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Builder(toBuilder = true)
@Entity(name = "film_actor")
@AllArgsConstructor
@NoArgsConstructor
public class FilmActor implements Serializable {

    @EmbeddedId
    private FilmActorKey id;

    private Timestamp lastUpdate;

    //bi-directional many-to-one association to Film
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="film_id", insertable = false, updatable = false)
    private Film film;

    //bi-directional many-to-one association to Actor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="actor_id", insertable = false, updatable = false)
    private Actor actor;
}
