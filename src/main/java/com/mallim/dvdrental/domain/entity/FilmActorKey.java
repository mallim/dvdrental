package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Builder(toBuilder = true)
@Embeddable
@NoArgsConstructor
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class FilmActorKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name="actor_id", insertable=false, updatable=false)
    private Integer actorId;

    @Column(name="film_id", insertable=false, updatable=false)
    private Integer filmId;
}
