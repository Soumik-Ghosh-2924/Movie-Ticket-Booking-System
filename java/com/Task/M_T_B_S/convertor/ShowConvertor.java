package com.Task.Movie_Ticket_Booking_System.convertor;


	import com.Task.Movie_Ticket_Booking_System.entities.Show;
	import com.Task.Movie_Ticket_Booking_System.request.ShowRequest;

	public class ShowConvertor {

	    public static Show showDtoToShow(ShowRequest showRequest) {
	        Show show = Show.builder()
	                .time(showRequest.getShowStartTime())
	                .date(showRequest.getShowDate())
	                .build();

	        return show;
	    }
	}


