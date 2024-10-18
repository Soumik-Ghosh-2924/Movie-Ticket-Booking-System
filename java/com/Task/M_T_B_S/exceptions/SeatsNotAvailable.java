package com.Task.Movie_Ticket_Booking_System.exceptions;

public class SeatsNotAvailable extends RuntimeException
{
	private static final long serialVersionUID = 1497113945165128412L;
	
	public SeatsNotAvailable()
	{
		super("Requested seats are not available.");
	}

}
