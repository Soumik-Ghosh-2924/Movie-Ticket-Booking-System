package com.Task.Movie_Ticket_Booking_System.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task.Movie_Ticket_Booking_System.request.MovieRequest;
import com.Task.Movie_Ticket_Booking_System.services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController 
{
	//the purpose of the movie controller is to add the new movie to the System's Database
	//This api is to be used by the Admin
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/addNew")
	public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest)
	{
		try
		{
			String result = movieService.addMovie(movieRequest);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

}
