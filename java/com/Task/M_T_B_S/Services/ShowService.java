package com.Task.Movie_Ticket_Booking_System.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Task.Movie_Ticket_Booking_System.convertor.ShowConvertor;
import com.Task.Movie_Ticket_Booking_System.entities.Movie;
import com.Task.Movie_Ticket_Booking_System.entities.Show;
import com.Task.Movie_Ticket_Booking_System.entities.ShowSeat;
import com.Task.Movie_Ticket_Booking_System.entities.Theater;
import com.Task.Movie_Ticket_Booking_System.entities.TheaterSeat;
import com.Task.Movie_Ticket_Booking_System.enums.SeatType;
import com.Task.Movie_Ticket_Booking_System.exceptions.MovieDoesNotExist;
import com.Task.Movie_Ticket_Booking_System.exceptions.ShowDoesNotExist;
import com.Task.Movie_Ticket_Booking_System.exceptions.TheaterDoesNotExist;
import com.Task.Movie_Ticket_Booking_System.repositories.MovieRepository;
import com.Task.Movie_Ticket_Booking_System.repositories.ShowRepository;
import com.Task.Movie_Ticket_Booking_System.repositories.TheaterRepository;
import com.Task.Movie_Ticket_Booking_System.request.ShowRequest;
import com.Task.Movie_Ticket_Booking_System.request.ShowSeatRequest;

@Service
public class ShowService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ShowRepository showRepository;

	public String addShow(ShowRequest showRequest) {
		Show show = ShowConvertor.showDtoToShow(showRequest);

		Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

		if (movieOpt.isEmpty()) {
			throw new MovieDoesNotExist();
		}

		Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

		if (theaterOpt.isEmpty()) {
			throw new TheaterDoesNotExist();
		}

		Theater theater = theaterOpt.get();
		Movie movie = movieOpt.get();

		show.setMovie(movie);
		show.setTheater(theater);
		show = showRepository.save(show);

		movie.getShows().add(show);
		theater.getShowList().add(show);

		movieRepository.save(movie);
		theaterRepository.save(theater);

		return "Show has been added Successfully";
	}

	public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExist {
		Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

		if (showOpt.isEmpty()) {
			throw new ShowDoesNotExist();
		}

		Show show = showOpt.get();
		Theater theater = show.getTheater();

		List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

		List<ShowSeat> showSeatList = show.getShowSeatList();

		for (TheaterSeat theaterSeat : theaterSeatList) {
			ShowSeat showSeat = new ShowSeat();
			showSeat.setSeatNo(theaterSeat.getSeatNo());
			showSeat.setSeatType(theaterSeat.getSeatType());

			if (showSeat.getSeatType().equals(SeatType.CLASSIC)) {
				showSeat.setPrice((showSeatRequest.getPriceOfClassicSeat()));
			} else {
				showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
			}

			showSeat.setShow(show);
			showSeat.setIsAvailable(Boolean.TRUE);
			showSeat.setIsFoodContains(Boolean.FALSE);

			showSeatList.add(showSeat);
		}

		showRepository.save(show);

		return "Show seats have been associated successfully";
	}
}