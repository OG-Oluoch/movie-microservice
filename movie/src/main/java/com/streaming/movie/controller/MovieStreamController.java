package com.streaming.movie.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class MovieStreamController {

    private final MovieCatalogService movieCatalogService;

    public MovieStreamController(MovieCatalogService movieCatalogService) {
        this.movieCatalogService = movieCatalogService;
    }

    public static final Logger log = Logger.getLogger(MovieStreamController.class.getName());
    public static final String VIDEO_FILE = "C:\\Users\\Admin\\Downloads\\auk.mp4";

    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamMovie(@PathVariable String videoPath) throws FileNotFoundException {

        File videoFile = new File(videoPath);
        if(videoFile.exists()){

            InputStreamResource streamResource = new InputStreamResource(new FileInputStream(videoFile));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(streamResource);

        }
        else {

          return  ResponseEntity.notFound().build();
        }


    }

    @GetMapping("/stream/with-id/{movieDetailsId}")
    public ResponseEntity<InputStreamResource> streamMovieById(Long movieDetailsId) throws FileNotFoundException {

      String videoPath = movieCatalogService.getMoviePathById(movieDetailsId);
      log.log(Level.INFO,"Resolved movie path ={0}", videoPath);

      return streamMovie(videoPath);


    }


}
