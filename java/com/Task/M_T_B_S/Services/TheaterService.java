package com.Task.Movie_Ticket_Booking_System.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task.Movie_Ticket_Booking_System.convertor.TheaterConvertor;
import com.Task.Movie_Ticket_Booking_System.entities.Theater;
import com.Task.Movie_Ticket_Booking_System.entities.TheaterSeat;
import com.Task.Movie_Ticket_Booking_System.enums.SeatType;
import com.Task.Movie_Ticket_Booking_System.exceptions.TheaterIsExist;
import com.Task.Movie_Ticket_Booking_System.exceptions.TheaterIsNotExist;
import com.Task.Movie_Ticket_Booking_System.repositories.TheaterRepository;
import com.Task.Movie_Ticket_Booking_System.request.TheaterRequest;
import com.Task.Movie_Ticket_Booking_System.request.TheaterSeatRequest;

import java.util.List;

@Service
public class TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	public String addTheater(TheaterRequest theaterRequest) throws TheaterIsExist {
		if (theaterRepository.findByAddress(theaterRequest.getAddress()) != null) {
			throw new TheaterIsExist();
		}
		
		Theater theater = TheaterConvertor.theaterDtoToTheater(theaterRequest);

		theaterRepository.save(theater);
		return "Theater has been saved Successfully";
	}

	public String addTheaterSeat(TheaterSeatRequest entryDto) throws TheaterIsNotExist {
		if (theaterRepository.findByAddress(entryDto.getAddress()) == null) {
			throw new TheaterIsNotExist();
		}
		
		Integer noOfSeatsInRow = entryDto.getNoOfSeatInRow();
		Integer noOfPremiumSeats = entryDto.getNoOfPremiumSeat();
		Integer noOfClassicSeat = entryDto.getNoOfClassicSeat();
		String address = entryDto.getAddress();

		Theater theater = theaterRepository.findByAddress(address);

		List<TheaterSeat> seatList = theater.getTheaterSeatList();
		
		
		//flag refers to the row in the theater
		//occupancy is the being occupied in a row
		//character is the letter mentioned on the seat
		
		
		
		int flag= 1;
		int occupancy = 0;
		char character = 'A';

		for (int i = 1; i <= noOfClassicSeat; i++) {
			String seatNo = Integer.toString(flag) + ch;

			character++;
			occupancy++;
			if (occupancy == noOfSeatsInRow) {
				occupancy = 0;
				flag++;
				character = 'A';
			}

			TheaterSeat theaterSeat = new TheaterSeat();
			theaterSeat.setSeatNo(seatNo);
			theaterSeat.setSeatType(SeatType.CLASSIC);
			theaterSeat.setTheater(theater);
			seatList.add(theaterSeat);
		}

		for (int i = 1; i <= noOfPremiumSeats; i++) {
			String seatNo = Integer.toString(flag) + character;

			character++;
			occupancy++;
			if (occupancy == noOfSeatsInRow) {
				occupancy = 0;
				flag++;
				character = 'A';
			}

			TheaterSeat theaterSeat = new TheaterSeat();
			theaterSeat.setSeatNo(seatNo);
			theaterSeat.setSeatType(SeatType.PREMIUM);
			theaterSeat.setTheater(theater);
			seatList.add(theaterSeat);
		}

		theaterRepository.save(theater);

		return "Theater Seats have been added successfully";
	}
}