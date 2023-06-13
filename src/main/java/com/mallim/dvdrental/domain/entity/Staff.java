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
