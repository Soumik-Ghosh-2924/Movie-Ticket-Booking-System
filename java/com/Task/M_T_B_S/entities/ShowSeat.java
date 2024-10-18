package com.Task.Movie_Ticket_Booking_System.entities;


import com.Task.Movie_Ticket_Booking_System.enums.SeatType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SHOW_SEATS")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;
    
    private Boolean isAvailable;
    
    private Boolean isFoodContains;

    @ManyToOne
    @JoinColumn
    private Show show;

	public void setSeatNo(String seatNo2) {
		
		this.seatNo=seatNo2;
		
	}

	public void setSeatType(SeatType seatType2) {
		this.seatType=seatType2;
		
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setPrice(Integer object) {
		this.price=object;
		
	}

	public void setShow(Show show2) {
		this.show=show2;
		
	}

	public void setIsAvailable(Boolean true1) {
		this.isAvailable=true1;
		
	}

	public void setIsFoodContains(Boolean false1) {
		this.isFoodContains=false1;
		
	}

	public String getSeatNo() {
		
		return seatNo;
	}

	public boolean getIsAvailable() {
		
		return isAvailable;
	}

	public Integer getPrice() {
		
		return price;
	}
}