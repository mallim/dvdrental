package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "rental_rental_id_seq_gen")
    @SequenceGenerator(name = "rental_rental_id_seq_gen", sequenceName = "rental_rental_id_seq",allocationSize = 1)
    private Integer rentalId;

    private Timestamp rentalDate;

    private Timestamp returnDate;

    private Timestamp lastUpdate;

    @OneToMany(mappedBy="rental")
    private List<Payment> payments = new ArrayList<>();

    //bi-directional many-to-one association to Customer
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    //bi-directional many-to-one association to Inventory
    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;

    //bi-directional many-to-one association to Staff
    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;

}
