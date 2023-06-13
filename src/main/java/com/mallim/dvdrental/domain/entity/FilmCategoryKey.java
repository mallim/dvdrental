package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class FilmCategoryKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name="film_id", insertable=false, updatable=false)
    private Integer filmId;

    @Column(name="category_id", insertable=false, updatable=false)
    private Integer categoryId;
}
