package com.Task.Movie_Ticket_Booking_System.request;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequest 
{
    private Integer showId;
    private Integer userId;
    private List<String> requestSeats;
	public Integer getShowId() 
	{
		return showId;
	}
	public Integer getUserId() {
		
		return userId;
	}
	public List<String> getRequestSeats() 
	{
		
		return requestSeats;
	}
}