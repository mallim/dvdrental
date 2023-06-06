package com.mallim.dvdrental.rent;

import com.mallim.dvdrental.domain.entity.Film;
import com.mallim.dvdrental.domain.entity.Payment;
import com.mallim.dvdrental.domain.entity.Rental;
import com.mallim.dvdrental.domain.repository.CustomerRepository;
import com.mallim.dvdrental.domain.repository.PaymentRepository;
import com.mallim.dvdrental.domain.repository.RentalRepository;
import com.mallim.dvdrental.domain.repository.StaffRepository;
import com.mallim.dvdrental.film.FilmService;
import com.mallim.dvdrental.rent.mapper.RentMapper;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RentService {

    private final FilmService filmService;

    private final CustomerRepository customerRepository;

    private final StaffRepository staffRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final RentMapper rentMapper;

    private final PaymentRepository paymentRepository;

    private final RentalRepository rentalRepository;

    @Transactional
    public List<Integer> rentFilm(RentMovieDto rentMovieDto) {
        final var filmList = filmService.findAllByIds(rentMovieDto.filmIds());
        final var totalCost = calculateTotalCostOfRent(rentMovieDto, filmList).orElseThrow(RuntimeException::new);
        final var customer = customerRepository.findByEmail(rentMovieDto.customerEmail()).
                orElseThrow(RuntimeException::new);
        final var staff = staffRepository.findById(1).orElseThrow(RuntimeException::new);
        final Payment.PaymentBuilder payment = rentMapper.toPayment(totalCost, customer, staff).toBuilder();
        final var rentals = filmList
                .stream()
                .map(vo -> rentMapper.toRental(vo, rentMovieDto, customer, payment.build(), staff))
                .collect(Collectors.toList());
        for (Rental ren : rentals) {
            payment.rental(ren);
        }
        final var rentalIds = rentalRepository.saveAll(rentals).stream().map(Rental::getRentalId).collect(Collectors.toList());
        final var save = paymentRepository.save(payment.build());
        if(save.getPaymentId()==null)
            throw new RuntimeException("Payment Failed!");
        return rentalIds;
    }

    private static Optional<BigDecimal> calculateTotalCostOfRent(RentMovieDto rentMovieDto, List<Film> filmList) {
        return filmList.stream().map(film -> film.getRentalRate().multiply(BigDecimal.valueOf(rentMovieDto.numberOfDays())))
                .reduce((bigDecimal, bigDecimal2) -> bigDecimal2.add(bigDecimal));
    }
}
