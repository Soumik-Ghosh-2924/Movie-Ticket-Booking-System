package com.Task.Movie_Ticket_Booking_System.convertor;


	import com.Task.Movie_Ticket_Booking_System.entities.Movie;
	import com.Task.Movie_Ticket_Booking_System.request.MovieRequest;

import lombok.Builder;
	@Builder
	public class MovieConvertor {

	    public static Movie movieDtoToMovie(MovieRequest movieRequest) {
	        Movie movie = Movie.builder()
	                .movieName(movieRequest.getMovieName())
	                .duration(movieRequest.getDuration())
	                .genre(movieRequest.getGenre())
	                .language(movieRequest.getLanguage())
	                .releaseDate(movieRequest.getReleaseDate())
	                .rating(movieRequest.getRating())
	                .build();

	        return movie ;
	    }
	}


