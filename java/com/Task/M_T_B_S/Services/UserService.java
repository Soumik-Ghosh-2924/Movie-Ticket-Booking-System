package com.Task.Movie_Ticket_Booking_System.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Task.Movie_Ticket_Booking_System.convertor.UserConvertor;
import com.Task.Movie_Ticket_Booking_System.entities.User;
import com.Task.Movie_Ticket_Booking_System.exceptions.UserExist;
import com.Task.Movie_Ticket_Booking_System.repositories.UserRepository;
import com.Task.Movie_Ticket_Booking_System.request.UserRequest;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String addUser(UserRequest userRequest) {
		Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());
		
		if (users.isPresent()) {
			throw new UserExist();
		}

		User user = UserConvertor.userDtoToUser(userRequest,  passwordEncoder.encode("1234"));

		userRepository.save(user);
		return "User Saved Successfully";
	}

}