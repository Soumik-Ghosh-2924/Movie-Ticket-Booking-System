package com.Task.Movie_Ticket_Booking_System.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Task.Movie_Ticket_Booking_System.entities.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}