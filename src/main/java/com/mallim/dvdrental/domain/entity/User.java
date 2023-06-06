package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class User implements Serializable {

    @Id
    private Integer id;

    private String loginid;

    private String username;

    private String password;

    private Boolean active;

}
