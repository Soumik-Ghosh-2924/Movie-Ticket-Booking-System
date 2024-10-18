package com.Task.Movie_Ticket_Booking_System.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.Task.Movie_Ticket_Booking_System.enums.Gender;

@Entity
@Table(name = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String mobileNo;

    @Column(unique = true)
    private String emailId;
    
    private String password;

	private String roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

	public List<Ticket> getTicketList() {
		
		return ticketList;
	}
}