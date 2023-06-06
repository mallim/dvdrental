package com.mallim.dvdrental.film;

import com.mallim.dvdrental.domain.entity.Film;
import com.mallim.dvdrental.film.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper {

    FilmMapper MAPPER = Mappers.getMapper(FilmMapper.class);

    @Mapping(target = "language", source = "language.name")
    FilmDto toDto( Film source ) ;
}
