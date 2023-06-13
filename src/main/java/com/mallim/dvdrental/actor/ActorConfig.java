package com.mallim.dvdrental.actor;

import com.mallim.dvdrental.domain.repository.ActorRepository;
import com.mallim.dvdrental.domain.repository.FilmActorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class ActorConfig {

    @Bean
    @Transactional(readOnly = true)
    public ActorService actorService(ActorRepository actorRepository, FilmActorRepository filmActorRepository ){
        return new ActorService( actorRepository, filmActorRepository, ActorMapper.MAPPER );
    }

}
