package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Film implements Serializable {

    @Id
    private Long filmId;

    private String title;

    private String description;

    private String releaseYear;

    private Integer rentalDuration;

    private BigDecimal rentalRate;

    private Integer length;

    private BigDecimal replacementCost;

    private String rating;

    private Timestamp lastUpdate;

    @SuppressWarnings("JpaAttributeTypeInspection")
    private List<String> specialFeatures;

    private String fulltext;

    @OneToOne
    @JoinColumn(name="language_id")
    private Language language;

    //bi-directional many-to-one association to FilmActor
    @OneToMany(mappedBy="film")
    private List<FilmActor> filmActors;

    //bi-directional many-to-one association to FilmCategory
    @OneToMany(mappedBy="film", fetch = FetchType.LAZY)
    private List<FilmCategory> filmCategories;

    //bi-directional many-to-one association to Inventory
    @OneToMany(mappedBy="film", fetch = FetchType.LAZY)
    private List<Inventory> inventories;

}
