package com.cinemapackage.cinemaproject.service;

import com.cinemapackage.cinemaproject.models.BookingHistory;
import com.cinemapackage.cinemaproject.models.Movie;
import com.cinemapackage.cinemaproject.models.NewMovieRequest;
import com.cinemapackage.cinemaproject.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMService{

	@Autowired
	private MovieRepository movieRepository ;
    
	
	@Override
    public List<Movie> filterMovies(String title, LocalDate date, String location, String genre)
    {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> filteredMovies = new ArrayList<>();

        for (Movie movie : movies) {
            boolean match = true;

            if (title != null && !movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                match = false;
            }
            if (date != null && !movie.getDate().isEqual(date)) {
                match = false;
            }
            if (location != null && !movie.getLocation().toLowerCase().contains(location.toLowerCase())) {
                match = false;
            }
            if (genre != null && !movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                match = false;
            }
            if (match) {
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }




	@Override
    public List<Movie> getAllMovies(String title, LocalDate date, String location, String genre) {
        if (title == null && date == null && location == null && genre == null) {
            return movieRepository.findAll();
        } else {
            return filterMovies(title, date, location, genre);
        }
    }

	
	@Override
    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
    }



	@Override
    public List<BookingHistory> getBookingHistory() {
        List<Movie> movies = movieRepository.findAll();
        List<BookingHistory> bookingHistory = new ArrayList<>();

        for (Movie movie : movies) {
            int bookedTickets = movie.getTotalSeats() - movie.getAvailableSeats();

            if (bookedTickets > 0) {
                int totalPrice = bookedTickets * movie.getPrice();

                BookingHistory booking = new BookingHistory();
                booking.setId(movie.getId());
                booking.setTitle(movie.getTitle());
                booking.setDirector(movie.getDirector());
                booking.setDescription(movie.getDescription());
                booking.setGenre(movie.getGenre());
                booking.setDate(movie.getDate());
                booking.setLocation(movie.getLocation());
                booking.setBookedTickets(bookedTickets);
                booking.setTotalPrice(totalPrice);
                bookingHistory.add(booking);
            }
        }
        return bookingHistory;
    }


    
    
    
    

    @Override
    public void bookTickets(Integer id, Integer tickets, Integer payment) 
    {
        Movie movie = getMovieById(id);

        int availableSeats = movie.getAvailableSeats();
        if (tickets > availableSeats) {
            throw new IllegalArgumentException("No seats available at this time.");
        }

        int calculatedTotalPrice = tickets * movie.getPrice();

        if (!payment.equals(calculatedTotalPrice)) {
            throw new IllegalArgumentException("Invalid total price.");
        }

        availableSeats -= tickets;
        movie.setAvailableSeats(availableSeats);

        movieRepository.save(movie);
    }



    
    
    
    

    @Override
    public void addMovie(NewMovieRequest req) {
        Movie movie = new Movie();
        movie.setDescription(req.getDescription());
        movie.setDirector(req.getDirector());
        movie.setGenre(req.getGenre());
        movie.setTitle(req.getTitle());
        movie.setDate(req.getDate());
        movie.setLocation(req.getLocation());
        movie.setTotalSeats(req.getTotalSeats());
        movie.setAvailableSeats(req.getAvailableSeats());
        movie.setPrice(req.getPrice());
        movieRepository.save(movie);
    }




    @Override
    public void deleteMovie(Integer id){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));

        movieRepository.delete(movie);
    }



    @Override
    public void updateMovie( Integer id, NewMovieRequest request){

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));

        movie.setDescription(request.getDescription());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setTitle(request.getTitle());
        movie.setDate(request.getDate());
        movie.setLocation(request.getLocation());
        movie.setTotalSeats(request.getTotalSeats());
        movie.setAvailableSeats(request.getAvailableSeats());
        movie.setPrice(request.getPrice());
        movieRepository.save(movie);
    }


}
