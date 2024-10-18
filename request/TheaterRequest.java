package com.Task.Movie_Ticket_Booking_System.request;

import lombok.Data;

@Data
public class TheaterRequest {

    private String name;
    private String address;
	public String getAddress() 
	{
		return this.address;
	}
}