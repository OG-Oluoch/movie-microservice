package com.movie_file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieFileApplication.class, args);
	}

}
