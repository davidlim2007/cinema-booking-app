package com.example.cinemabookingapp.controllers;

import com.example.cinemabookingapp.repositories.MoviesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cinemabookingapp.models.Movie;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
    @Autowired
    private MoviesRepository moviesRepository;

    @GetMapping
    public List<Movie> getAll() {
        return moviesRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{movie_id}")
    public Movie getMovie(@PathVariable Long movie_id) {
        return moviesRepository.getReferenceById(movie_id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody final Movie movie) {
        return moviesRepository.saveAndFlush(movie);
    }

    @RequestMapping(value = "{movie_id}", method = RequestMethod.PUT)
    public Movie updateMovie(@PathVariable Long movie_id, @RequestBody Movie movie) {
        Movie existingMovie = moviesRepository.getReferenceById(movie_id);
        BeanUtils.copyProperties(movie, existingMovie, "movie_id");
        return moviesRepository.saveAndFlush(existingMovie);
    }

    @DeleteMapping("{movie_id}")
    public void deleteMovie(@PathVariable Long movie_id) {
        moviesRepository.deleteById(movie_id);
    }
}

