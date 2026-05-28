package com.movie_file.controller;

import com.movie_file.model.MovieDetails;
import com.movie_file.model.MovieRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieDetailsController {


    private final MovieRepo movieRepo;

    public MovieDetailsController(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @PostMapping("/movie-details/save")
    public List<MovieDetails> saveAllMovies(@RequestBody List<MovieDetails> movieDetailsList){

        return movieRepo.saveAll(movieDetailsList);

    }

    @GetMapping("/movie-details/list")
    public List<MovieDetails> getAll(){

        return movieRepo.findAll();
    }
}
