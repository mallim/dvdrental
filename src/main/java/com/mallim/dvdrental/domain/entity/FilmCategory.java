package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "film_category")
@ToString(exclude = {"category", "film"})
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class FilmCategory implements Serializable {

    @Serial
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
