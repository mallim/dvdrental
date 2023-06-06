package com.mallim.dvdrental.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerList implements Serializable {

    private Long id;

    private String name;

    private String address;

    private String zipCode;

    private String phone;

    private String city;

    private String country;

    private String notes;

    private Short sid;
}
