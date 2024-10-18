package com.Task.Movie_Ticket_Booking_System.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.Task.Movie_Ticket_Booking_System.enums.Genre;
import com.Task.Movie_Ticket_Booking_System.enums.Language;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String movieName;

    private Integer duration;

    @Column(scale = 2)
    private Double rating;

    private Date releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();

	public Object getLanguage() {
		
		return language;
	}

	public List<Show> getShows() 
	{
		return shows;
	}
}
