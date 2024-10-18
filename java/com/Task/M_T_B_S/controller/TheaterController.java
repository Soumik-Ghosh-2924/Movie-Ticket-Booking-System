package com.Task.Movie_Ticket_Booking_System.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task.Movie_Ticket_Booking_System.request.TheaterRequest;
import com.Task.Movie_Ticket_Booking_System.request.TheaterSeatRequest;
import com.Task.Movie_Ticket_Booking_System.services.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController 
{
	@Autowired
	private TheaterService theaterService;
	
	//This API is to add new Theater into the System
	@PostMapping("/addNew")
	public	ResponseEntity<String> addTheater(@RequestBody TheaterRequest request)
	{
		try
		{
			String result = theaterService.addTheater(request);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	//This API is to add Theater Seat into the System
	@PostMapping("/addTheaterSeat")
	public ResponseEntity<String> addTheaterSeat(@RequestBody TheaterSeatRequest entryDto)
	{
		try
		{
			String result = theaterService.addTheaterSeat(entryDto);
			return new ResponseEntity<>(result,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
			
	

}
