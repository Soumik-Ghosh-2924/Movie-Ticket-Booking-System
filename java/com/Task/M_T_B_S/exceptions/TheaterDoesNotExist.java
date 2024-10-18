package com.Task.Movie_Ticket_Booking_System.exceptions;

public class TheaterDoesNotExist extends RuntimeException 
{
	private static long serialVersionUID = 2885350098352987873L;
	
	public TheaterDoesNotExist()
	{
		super ("Theater does not exist.");
	}

}
