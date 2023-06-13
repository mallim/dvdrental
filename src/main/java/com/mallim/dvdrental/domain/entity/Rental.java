package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(exclude = {"payments","customer","inventory","staff"})
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Rental implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "rental_rental_id_seq_gen")
    @SequenceGenerator(name = "rental_rental_id_seq_gen", sequenceName = "rental_rental_id_seq",allocationSize = 1)
    private Integer rentalId;

    private Timestamp rentalDate;

    private Timestamp returnDate;

    private Timestamp lastUpdate;

    @OneToMany(mappedBy="rental")
    @Builder.Default
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
