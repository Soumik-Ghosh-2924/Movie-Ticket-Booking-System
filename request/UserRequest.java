package com.Task.Movie_Ticket_Booking_System.request;

import com.Task.Movie_Ticket_Booking_System.enums.Gender;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private String roles;
	public String getEmailId() 
	{
		return emailId;
	}
}