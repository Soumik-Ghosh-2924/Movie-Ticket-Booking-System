package com.Task.Movie_Ticket_Booking_System.exceptions;

public class MovieDoesNotExist extends RuntimeException
{
	private static final long serialVersionUID = -5385129013790060351L;
	
	public MovieDoesNotExist()
	{
		super("Movie does not Exist.");
	}

}
