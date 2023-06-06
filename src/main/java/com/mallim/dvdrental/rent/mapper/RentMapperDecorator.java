package com.mallim.dvdrental.rent.mapper;

import com.mallim.dvdrental.domain.entity.*;
import com.mallim.dvdrental.rent.RentMovieDto;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public abstract class RentMapperDecorator implements RentMapper{

    private final RentMapper delegate;

    @Override
    public Rental toRental( Film film, RentMovieDto rentMovieDto, Customer customer, Payment payment, Staff staff ){
        Rental result = delegate.toRental(film, rentMovieDto, customer, payment, staff);
        Rental.RentalBuilder builder = result.toBuilder();
        if( Objects.isNull( result.getPayments() ) ) {
            builder.payments( new java.util.ArrayList<>() );
        }
        result.getPayments().add( payment );
        return result;
    }
}
