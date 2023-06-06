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
public class Staff implements Serializable {

    @Id
    private Integer staffId;

    private String firstName;

    private String lastName;

    private Short addressId;

    private String email;

    private Short storeId;

    private Boolean active;

    private String username;

    private String password;

    private Date lastUpdate;

    private byte[] picture;

}
