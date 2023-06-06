package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(exclude = {"customer", "rental", "staff"})
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "payment_payment_id_seq_gen")
    @SequenceGenerator(name = "payment_payment_id_seq_gen", sequenceName = "payment_payment_id_seq", allocationSize = 1)
    private Integer paymentId;

    private BigDecimal amount;

    private Timestamp paymentDate;

    //bi-directional many-to-one association to Customer
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    //bi-directional many-to-one association to Rental
    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;

    //bi-directional many-to-one association to Staff
    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;
}
