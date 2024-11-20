package com.cinemapackage.cinemaproject.service;

import java.time.LocalDate;
import java.util.List;

import com.cinemapackage.cinemaproject.models.BookingHistory;
import com.cinemapackage.cinemaproject.models.Movie;
import com.cinemapackage.cinemaproject.models.NewMovieRequest;

public interface IMService 
{
	//This is to ensure the Loose Coupling between the MovieService and MovieController
	public List<Movie> filterMovies(String title, LocalDate date, String location, String genre);
	public List<Movie> getAllMovies(String title, LocalDate date, String location, String genre);
	public Movie getMovieById(Integer id);
	public List<BookingHistory> getBookingHistory();
	public void bookTickets(Integer id, Integer tickets, Integer payments);
	public void addMovie(NewMovieRequest req);
	public void deleteMovie(Integer id);
	public void updateMovie(Integer id, NewMovieRequest req);

}
