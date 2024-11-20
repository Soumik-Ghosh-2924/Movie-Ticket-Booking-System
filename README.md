# Movie Ticket Booking System

This project, aims to build a comprehensive backend system for a movie ticket booking platform. The application enables users to explore available movies, book tickets, process payments, and access their booking history. Built with Java and Spring Boot, this system leverages RESTful APIs and is designed with scalability in mind.


# How to use this Repository :
**Steps :** <br>
    *1.*  Clone this repository in your local machine. <br>
    *2.*  Make certian Package changes if u want and also in the dependencies if u want to modify it further.<br>
    *3.*  Make use of Postman as a Rest Client in order to check the API Endpoints work properly as per automated in the process.<br>

## Features

- **Browse Movies**: View a curated list of movies available for booking.
- **Search and Filter**: Search movies by title, date, location, genre, or movie ID for a tailored browsing experience.
- **Movie Details**: Access in-depth information on movies, including title, director, description, genre, screening date, location, seating capacity, ticket availability, and price.
- **Ticket Booking**: Book tickets by selecting a movie ID, ticket quantity, and total price for secure reservations.
- **Booking History**: View booking history with details on previously booked movies, such as title, director, description, genre, screening date, location, number of tickets, and total price.
- **Admin Controls**: Admin users can manage movie listings by adding new movies, updating existing ones, or deleting movies as needed.

## Technologies

- **Backend**: Java, Spring Boot, Spring Data JPA
- **Database**: PostgreSQL
- **API Testing**: Postman

## API Endpoints

| Method | Endpoint                            | Description                                                |
|--------|-------------------------------------|------------------------------------------------------------|
| GET    | `/movie`                            | Retrieve a list of available movies.                       |
| GET    | `/movie/{id}`                       | Retrieve detailed information about a specific movie.      |
| GET    | `/movie?genre=Drama`                | Retrieve movies filtered by genre.                         |
| GET    | `/movie?date=2024-05-10`            | Retrieve movies filtered by screening date.                |
| GET    | `/movie?title=Whiplash`             | Retrieve movies filtered by title.                         |
| GET    | `/movie?location=Cineplexx`         | Retrieve movies filtered by location.                      |
| GET    | `/movie/booking/history`            | Retrieve the user’s booking history.                       |
| POST   | `/movie`                            | Add a new movie to the catalog (Admin only).               |
| POST   | `/movie/booking/{movieId}/{tickets}/{payment}` | Create a new booking for a selected movie. |
| DELETE | `/movie/{movieId}`                  | Delete an existing movie (Admin only).                     |
| PUT    | `/movie/{movieId}`                  | Update movie details (Admin only).                         |

---

