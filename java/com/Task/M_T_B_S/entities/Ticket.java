package com.Task.Movie_Ticket_Booking_System.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "TICKETS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;

	private Integer totalTicketsPrice;

	private String bookedSeats;

	@CreationTimestamp
	private Date bookedAt;

	@ManyToOne
	@JoinColumn
	private Show show;

	@ManyToOne
	@JoinColumn
	private User user;

	public void setTotalTicketsPrice(Integer getPriceAndAssignSeats) {
		this.totalTicketsPrice=getPriceAndAssignSeats;
		
	}

	public void setBookedSeats(String seats) {
		
		this.bookedSeats=seats;
		
	}

	public void setUser(User user2) {
		this.user=user2;
		
	}

	public void setShow(Show show2) {
		this.show=show2;
		
	}

}
