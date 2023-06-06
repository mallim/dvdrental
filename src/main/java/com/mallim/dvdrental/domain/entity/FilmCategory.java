package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "film_category")
public class FilmCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FilmCategoryKey id;

    private Timestamp lastUpdate;

    //bi-directional many-to-one association to Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", insertable = false, updatable = false)
    private Category category;

    //bi-directional many-to-one association to Film
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="film_id", insertable = false, updatable = false)
    private Film film;
}
