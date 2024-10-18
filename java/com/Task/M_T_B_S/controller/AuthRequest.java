package com.Task.Movie_Ticket_Booking_System.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest 
{
	private String username;
	private String password;
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

}
