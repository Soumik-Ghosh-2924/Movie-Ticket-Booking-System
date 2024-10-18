package com.Task.Movie_Ticket_Booking_System.request;

import java.sql.Date;

import com.Task.Movie_Ticket_Booking_System.enums.Genre;
import com.Task.Movie_Ticket_Booking_System.enums.Language;

import lombok.Data;

@Data
public class MovieRequest 
{
	private String movieName;
	private Integer duration;
	private Double rating;
	private Date releaseDate;
	private Genre genre;
	private Language language;
	public Object getLanguage() 
	{
		
		return language;
	}
	public String getMovieName() 
	{
		
		return movieName;
	}

}
