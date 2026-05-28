package com.streaming.movie.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
public class MovieStreamController {

    public static final String VIDEO_FILE = "C:\\Users\\Admin\\Downloads\\auk.mp4";

    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamMovie(String videoPath) throws FileNotFoundException {

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
}
