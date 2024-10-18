package com.Task.Movie_Ticket_Booking_System.exceptions;

public class ShowDoesNotExist extends RuntimeException {
	
private static final long serialVersionUID = -4436119261176031165L;
	
	public ShowDoesNotExist()
	{
		super("Show does not exist.");
	}

}
