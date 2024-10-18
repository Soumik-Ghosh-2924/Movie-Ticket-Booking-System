package com.Task.Movie_Ticket_Booking_System.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Task.Movie_Ticket_Booking_System.config.JWTService;
import com.Task.Movie_Ticket_Booking_System.exceptions.UserDoesNotExist;
import com.Task.Movie_Ticket_Booking_System.request.UserRequest;
import com.Task.Movie_Ticket_Booking_System.services.UserService;

import jakarta.annotation.Resource.AuthenticationType;

@RestController
@RequestMapping("/user")
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationType authenticationManager;
	
	@Autowired
	private JWTService jwtService;
	
	
	@PostMapping("/addNew")
	public ResponseEntity<String> addNewUser(@RequestBody UserRequest userEntryDto)
	{
		try
		{
			String result = userService.addUser(userEntryDto);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/getToken")
	public String authenticationAndGetToken(@RequestBody AuthRequest authRequest)
	{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(authRequest.getUsername());
		}
		
		throw new UserDoesNotExist();
	}

}
