package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FilmCategoryKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="film_id", insertable=false, updatable=false)
    private Integer filmId;

    @Column(name="category_id", insertable=false, updatable=false)
    private Integer categoryId;
}
