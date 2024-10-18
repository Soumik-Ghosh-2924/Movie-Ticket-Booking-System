package com.Task.Movie_Ticket_Booking_System.request;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String address;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
	public String getAddress() {
		return address;
	}
	public Integer getNoOfSeatInRow() 
	{
		return noOfSeatInRow;
	}
	
	public Integer getNoOfPremiumSeat() 
	{
		return noOfPremiumSeat;
	}
	public Integer getNoOfClassicSeat() 
	{
		return noOfClassicSeat;
	}
}