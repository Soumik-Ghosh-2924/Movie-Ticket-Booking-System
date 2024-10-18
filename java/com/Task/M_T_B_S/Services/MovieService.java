package com.Task.Movie_Ticket_Booking_System.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task.Movie_Ticket_Booking_System.convertor.MovieConvertor;
import com.Task.Movie_Ticket_Booking_System.entities.Movie;
import com.Task.Movie_Ticket_Booking_System.exceptions.MovieAlreadyExist;
import com.Task.Movie_Ticket_Booking_System.repositories.MovieRepository;
import com.Task.Movie_Ticket_Booking_System.request.MovieRequest;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public String addMovie(MovieRequest movieRequest) {
		Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());
		
		if (movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
			throw new MovieAlreadyExist();
		}
		
		Movie movie = MovieConvertor.movieDtoToMovie(movieRequest);
		
		movieRepository.save(movie);
		return "The movie has been added successfully";
	}

}