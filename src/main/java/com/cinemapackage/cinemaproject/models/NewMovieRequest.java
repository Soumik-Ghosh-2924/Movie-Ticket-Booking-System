package com.cinemapackage.cinemaproject.models;

import java.time.LocalDate;


//This is the DTO class for the application being the carrier of data to and fro  the DB.

public class NewMovieRequest
{
    private String description;
    private String director;
    private String genre;
    private String title;
    private LocalDate date;
    private String location;
    private int totalSeats;
    private int availableSeats;
    private int price;


    public NewMovieRequest
            (String description,String director,
            String genre, String title,
            LocalDate date, String location,
             int totalSeats, int availableSeats,
            int price)
    {
        this.description=description;
        this.director=director;
        this.genre=genre;
        this.title=title;
        this.date=date;
        this.location=location;
        this.totalSeats=totalSeats;
        this.availableSeats=availableSeats;
        this.price=price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
