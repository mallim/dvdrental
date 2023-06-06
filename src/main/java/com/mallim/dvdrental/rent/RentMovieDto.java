package com.mallim.dvdrental.rent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
@Data
public class RentMovieDto {
    private String customerEmail;
    private Integer numberOfDays;
    private List<Long> filmIds;
}
