package com.mallim.dvdrental.domain.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

import java.time.Year;

@Slf4j
@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        short year = (short) attribute.getValue();
        log.info("Convert Year ["+attribute+"] to short ["+year+"]");
        return year;
    }

    @Override
    public Year convertToEntityAttribute(Short dbValue) {
        Year year = Year.of(dbValue);
        log.info("Convert Short ["+dbValue+"] to Year ["+year+"]");
        return year;
    }
}

