
package com.cinemapackage.cinemaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemapackage.cinemaproject.models.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> 
{
	
}