package com.mallim.dvdrental.domain.entity;

import lombok.*;

import java.io.Serializable;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class ActorInfo implements Serializable {

    private Long actorId;

    private String firstName;

    private String lastName;

    private String filmInfo;
}
