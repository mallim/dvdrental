package com.mallim.dvdrental.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("rent")
public class RentController {

    private final RentService rentService;

    @PostMapping
    public List<Integer> rentMovies(@RequestBody RentMovieDto rentMovieDto){
        return rentService.rentFilm(rentMovieDto);
    }
}
