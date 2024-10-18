package com.Task.Movie_Ticket_Booking_System.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Task.Movie_Ticket_Booking_System.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Integer> 
{
	
}