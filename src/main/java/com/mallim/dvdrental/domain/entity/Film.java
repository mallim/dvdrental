package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Year;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long filmId;

    private String title;

    private String description;

    private Year releaseYear;

    private Integer rentalDuration;

    private BigDecimal rentalRate;

    private Integer length;

    private BigDecimal replacementCost;

    private Rating rating;

    private Timestamp lastUpdate;

    @SuppressWarnings("JpaAttributeTypeInspection")
    private List<String> specialFeatures;

    private String fulltext;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="language_id")
    private Language language;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="original_language_id")
    private Language originalLanguage;

    //bi-directional many-to-one association to FilmActor
    @OneToMany(mappedBy="film")
    @ToString.Exclude
    private List<FilmActor> filmActors;

    //bi-directional many-to-one association to FilmCategory
    @OneToMany(mappedBy="film", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FilmCategory> filmCategories;

    //bi-directional many-to-one association to Inventory
    @OneToMany(mappedBy="film", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Inventory> inventories;

}
