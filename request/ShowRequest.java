package com.Task.Movie_Ticket_Booking_System.request;


import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ShowRequest {

    private Time showStartTime;
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
	public Integer getMovieId() 
	{
		return movieId;
	}
	
	public Integer getTheaterId() 
	{
		
		return theaterId;
	}
}