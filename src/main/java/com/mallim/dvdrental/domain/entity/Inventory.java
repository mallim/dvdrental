package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(exclude = {"rentals", "film"})
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Inventory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer inventoryId;

    private Integer storeId;

    private Timestamp lastUpdate;

    //bi-directional many-to-one association to Film
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="film_id")
    private Film film;

    //bi-directional many-to-one association to Rental
    @OneToMany(mappedBy="inventory", fetch = FetchType.LAZY)
    private List<Rental> rentals;

}
