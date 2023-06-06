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
public class ActorInfo implements Serializable {

    private Long actorId;

    private String firstName;

    private String lastName;

    private String filmInfo;
}
