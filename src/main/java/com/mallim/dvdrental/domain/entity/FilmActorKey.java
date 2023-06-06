package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@Embeddable
@NoArgsConstructor
public class FilmActorKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name="actor_id", insertable=false, updatable=false)
    private Integer actorId;

    @Column(name="film_id", insertable=false, updatable=false)
    private Integer filmId;
}
