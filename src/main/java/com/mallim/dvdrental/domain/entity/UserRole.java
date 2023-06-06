package com.mallim.dvdrental.domain.entity;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class UserRole implements Serializable {

    private Integer id;

    private Long roleId;

    private Long userId;

}
