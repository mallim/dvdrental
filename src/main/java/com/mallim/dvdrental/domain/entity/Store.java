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
public class Store implements Serializable {

    @Id
    private Integer storeId;

    private Short managerStaffId;

    private Short addressId;

    private Date lastUpdate;

}
