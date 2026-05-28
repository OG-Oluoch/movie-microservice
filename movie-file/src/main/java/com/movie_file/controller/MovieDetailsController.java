package com.movie_file.controller;

import com.movie_file.model.MovieDetails;
import com.movie_file.model.MovieRepo;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/movie-details/find-path-id/{movieId}")
    public String findPathById(@PathVariable Long movieId){

        var optionalMovieDetails = movieRepo.findById(movieId);

        return optionalMovieDetails.map(MovieDetails::getPath).orElse(null);

    }
}
