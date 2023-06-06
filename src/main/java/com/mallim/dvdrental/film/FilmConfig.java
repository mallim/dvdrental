package com.mallim.dvdrental.film;

import com.mallim.dvdrental.domain.repository.FilmRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class FilmConfig {

    @Bean
    @Transactional(readOnly = true)
    public FilmService filmService( FilmRepository filmRepository ){
        return new FilmService( filmRepository, FilmMapper.MAPPER );
    }

}
