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
@Entity
public class Store implements Serializable {

    @Id
    private Integer storeId;

    private Short managerStaffId;

    private Short addressId;

    private Date lastUpdate;

}
