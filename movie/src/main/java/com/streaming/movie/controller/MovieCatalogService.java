package com.streaming.movie.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component

public class MovieCatalogService {

    static final String FILE_SERVICE_URL = "http://movie-file";

    private final RestTemplate restTemplate;

    public MovieCatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public String getMoviePathById(Long movieId){

      var response = restTemplate.getForEntity(FILE_SERVICE_URL+"/movie-details/find-path-id/{movieId}", String.class, movieId);

      return response.getBody();
    }
}
