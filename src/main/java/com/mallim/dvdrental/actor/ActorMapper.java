package com.mallim.dvdrental.actor;

import com.mallim.dvdrental.actor.dto.ActorDto;
import com.mallim.dvdrental.domain.entity.Actor;
import com.mallim.dvdrental.domain.entity.Film;
import com.mallim.dvdrental.film.dto.ActorFilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;

@Mapper(imports={Timestamp.class})
public interface ActorMapper {

    ActorMapper MAPPER = Mappers.getMapper(ActorMapper.class);

    ActorDto toDto( Actor customer );

    @Mapping(target="lastUpdate", expression="java(new Timestamp(System.currentTimeMillis()) )")
    Actor toActor( ActorDto payload );

    @Mapping(target="actorId", source="actorId")
    @Mapping(target="firstName", source="payload.firstName")
    @Mapping(target="lastName", source="payload.lastName")
    @Mapping(target="lastUpdate", expression="java(new Timestamp(System.currentTimeMillis()) )")
    Actor toActor( Integer actorId, ActorDto payload );

    @Mapping(target = "language", source = "language.name")
    ActorFilmDto toActorFilmDto( Film film );
}
