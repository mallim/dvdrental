package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable {

    @Id
    private Integer customerId;

    private Short storeId;

    private String firstName;

    private String lastName;

    private String email;

    private Short addressId;

    private Boolean activebool;

    private Date createDate;

    private Date lastUpdate;

    private Integer active;

}
