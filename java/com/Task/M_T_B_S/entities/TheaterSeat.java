package com.Task.Movie_Ticket_Booking_System.entities;


import com.Task.Movie_Ticket_Booking_System.enums.SeatType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "THEATER_SEATS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;

	public String getSeatNo() {
		return seatNo;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatNo(String seatNo2) 
	{
		this.seatNo=seatNo2;
	}

	public void setSeatType(SeatType premium) {
		this.seatType=premium;
		
	}

	public void setTheater(Theater theater2) {
		this.theater=theater2;
		
	}
	
	
	
}