package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Actor implements Serializable {

    @Id
    private Integer actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;

}
