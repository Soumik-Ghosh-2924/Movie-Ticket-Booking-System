package com.Task.Movie_Ticket_Booking_System.convertor;


	import com.Task.Movie_Ticket_Booking_System.entities.Show;
	import com.Task.Movie_Ticket_Booking_System.entities.Ticket;
	import com.Task.Movie_Ticket_Booking_System.response.TicketResponse;

	public class TicketConvertor {

	    public static TicketResponse returnTicket(Show show, Ticket ticket) {
	        TicketResponse ticketResponseDto = TicketResponse.builder()
	                .bookedSeats(ticket.getBookedSeats())
	                .address(show.getTheater().getAddress())
	                .theaterName(show.getTheater().getName())
	                .movieName(show.getMovie().getMovieName())
	                .date(show.getDate())
	                .time(show.getTime())
	                .totalPrice(ticket.getTotalTicketsPrice())
	                .build();

	        return ticketResponseDto;
	    }
	}

