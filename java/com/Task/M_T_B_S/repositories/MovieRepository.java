package com.Task.Movie_Ticket_Booking_System.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Task.Movie_Ticket_Booking_System.entities.Movie;
public interface MovieRepository extends JpaRepository<Movie, Integer> 
{
	Movie findByMovieName(String name);
	

}
