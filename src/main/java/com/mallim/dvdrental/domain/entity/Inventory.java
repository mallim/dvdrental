package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
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
