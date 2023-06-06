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
public class Language implements Serializable {

    @Id
    private Integer languageId;

    private String name;

    private Date lastUpdate;

}
