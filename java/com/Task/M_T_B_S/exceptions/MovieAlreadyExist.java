package com.Task.Movie_Ticket_Booking_System.exceptions;

public class MovieAlreadyExist extends RuntimeException
{
	private static final long serialVersionUID = 87214071728310561L;
	
	public MovieAlreadyExist()
	{
		super("Movie already exists with the same name and language");
	}
	

}
