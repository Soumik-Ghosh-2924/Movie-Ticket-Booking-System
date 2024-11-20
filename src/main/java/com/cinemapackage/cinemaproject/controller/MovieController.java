package com.cinemapackage.cinemaproject.controller;

import com.cinemapackage.cinemaproject.models.BookingHistory;
import com.cinemapackage.cinemaproject.models.Movie;
import com.cinemapackage.cinemaproject.models.NewMovieRequest;
import com.cinemapackage.cinemaproject.service.IMService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MovieController {

	@Autowired
    private  IMService movieService;
   

    @GetMapping("/movie")
    public List<Movie> getMovies(@RequestParam(required = false) String title,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String genre) 
    {
    	return movieService.getAllMovies(title, date, location, genre);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/booking/history")
    public List<BookingHistory> getBookingHistory(){
        return movieService.getBookingHistory();
    }


    @PostMapping("/movie")
    public void addMovie(@RequestBody com.cinemapackage.cinemaproject.models.NewMovieRequest req) {
        movieService.addMovie(req);
        return;
    }

    
    
    
    @PostMapping("/booking/{movieId}/{quantity}/{totalPrice}")
    public void createBooking(
            @PathVariable("movieId") Integer id,
            @PathVariable("quantity") Integer quantity,
            @PathVariable("totalPrice") Integer totalPrice
    ) {
        movieService.bookTickets(id, quantity, totalPrice);
    }
    
    
    
    
    
    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Integer id) {
        movieService.deleteMovie(id);
    }

    
    
    
    
    
    @PutMapping("/movie/{movieId}")
    public void updateMovie(@PathVariable("movieId") Integer id, @RequestBody NewMovieRequest movie) 
    {
        movieService.updateMovie(id, movie);
    }


}