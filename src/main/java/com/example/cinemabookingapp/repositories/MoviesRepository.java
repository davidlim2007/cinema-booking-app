package com.example.cinemabookingapp.repositories;

import com.example.cinemabookingapp.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameContains(String name);
}

