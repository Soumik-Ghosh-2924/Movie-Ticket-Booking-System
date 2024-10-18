package com.Task.Movie_Ticket_Booking_System.convertor;


	import com.Task.Movie_Ticket_Booking_System.entities.Theater;
	import com.Task.Movie_Ticket_Booking_System.request.TheaterRequest;

	public class TheaterConvertor {

	    public static Theater theaterDtoToTheater(TheaterRequest theaterRequest) {
	        Theater theater = Theater.builder()
	                .name(theaterRequest.getName())
	                .address(theaterRequest.getAddress())
	                .build();
	        return theater;
	    }
	}


