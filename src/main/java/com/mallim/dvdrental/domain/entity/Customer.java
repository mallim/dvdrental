package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
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
