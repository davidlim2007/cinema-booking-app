package com.example.cinemabookingapp.repositories;

import com.example.cinemabookingapp.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movie, Long> {
}

