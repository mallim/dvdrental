package com.mallim.dvdrental.rent;

import java.util.List;

public record RentMovieDto( String customerEmail, Integer numberOfDays, List<Long> filmIds) {
}
