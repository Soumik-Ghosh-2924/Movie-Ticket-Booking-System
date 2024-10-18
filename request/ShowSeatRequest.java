package com.Task.Movie_Ticket_Booking_System.request;

import lombok.Data;

@Data
public class ShowSeatRequest {
    private Integer showId;
    private Integer priceOfPremiumSeat;
    private Integer priceOfClassicSeat;
	public Integer getShowId() 
	{
		return showId;
	}
	
	public Integer getPriceOfClassicSeat() 
	{		
		return priceOfClassicSeat;
	}
	
	public Integer getPriceOfPremiumSeat() 
	{		
		return priceOfPremiumSeat;
	}
}