package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Movie;
import com.pro.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService service;

	@PostMapping("/movies")
	private ResponseEntity<?> add(@RequestBody Movie movie) {
		if (service.addMovie(movie))
			return ResponseEntity.ok("Movie details added Successfully....");
		else
			return ResponseEntity.ok("Unable to add movie details");
	}

	@GetMapping("/movies")
	private ResponseEntity<?> get() {
		return ResponseEntity.ok(service.getAllMovie());
	}

	@GetMapping("/movies/{id}")
	private ResponseEntity<?> get(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.getMovie(Integer.parseInt(id)));
	}

	@DeleteMapping("/movies/{id}")
	private ResponseEntity<?> delete(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.deleteMovie(Integer.parseInt(id)));
	}

	@PutMapping("/movies/{id}")
	private ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable("id") String id) {
		return ResponseEntity.ok(service.updateMovie(Integer.parseInt(id), movie));
	}
}
