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
    @RequestMapping("{id}")
    public Movie getMovie(@PathVariable Long movies_id) {
        return moviesRepository.getReferenceById(movies_id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody final Movie movie) {
        return moviesRepository.saveAndFlush(movie);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Movie updateMovie(@PathVariable Long movies_id, @RequestBody Movie movie) {
        Movie existingMovie = moviesRepository.getReferenceById(movies_id);
        BeanUtils.copyProperties(movie, existingMovie, "movie_id");
        return moviesRepository.saveAndFlush(existingMovie);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    public void deleteMovie(@PathVariable Long movies_id) {
        moviesRepository.deleteById(movies_id);
    }
}

