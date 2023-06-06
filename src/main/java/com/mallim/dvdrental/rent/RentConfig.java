package com.mallim.dvdrental.rent;

import com.mallim.dvdrental.domain.repository.CustomerRepository;
import com.mallim.dvdrental.domain.repository.PaymentRepository;
import com.mallim.dvdrental.domain.repository.RentalRepository;
import com.mallim.dvdrental.domain.repository.StaffRepository;
import com.mallim.dvdrental.film.FilmService;
import com.mallim.dvdrental.rent.mapper.RentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RentConfig {

    @Bean
    public RentService rentService( FilmService filmService,
                                    CustomerRepository customerRepository,
                                    StaffRepository staffRepository,
                                    PaymentRepository paymentRepository,
                                    RentalRepository rentalRepository ){
        return new RentService( filmService,
                                customerRepository,
                                staffRepository,
                                RentMapper.MAPPER,
                                paymentRepository,
                                rentalRepository );
    }
}
