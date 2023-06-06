package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class City implements Serializable {

    @Id
    private Integer cityId;

    private String city;

    private Short countryId;

    private Date lastUpdate;

}
