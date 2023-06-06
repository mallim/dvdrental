package com.mallim.dvdrental.rent.mapper;

import com.mallim.dvdrental.domain.entity.*;
import com.mallim.dvdrental.rent.RentMovieDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Mapper(imports={ChronoUnit.class, Timestamp.class, Instant.class})
@DecoratedWith(RentMapperDecorator.class)
public interface RentMapper {

    RentMapper MAPPER = Mappers.getMapper(RentMapper.class);

    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "amount", source = "totalCost")
    @Mapping(target = "staff", source = "staff")
    @Mapping(target = "paymentDate", expression = "java( new Timestamp(System.currentTimeMillis()) )")
    Payment toPayment( BigDecimal totalCost, Customer customer, Staff staff );

    @Mapping(target="customer", source="customer")
    @Mapping(target="staff", source="staff")
    @Mapping(target="inventory", expression="java(film.getInventories().get(0))")
    @Mapping(target="lastUpdate", expression="java(new Timestamp(System.currentTimeMillis()) )")
    @Mapping(target="rentalDate", expression = "java( new Timestamp(System.currentTimeMillis()) )")
    @Mapping(target="returnDate", expression="java(new Timestamp(Instant.now().plus(rentMovieDto.getNumberOfDays(), ChronoUnit.DAYS).toEpochMilli()))")
    Rental toRental( Film film, RentMovieDto rentMovieDto, Customer customer, Payment payment, Staff staff );

}
