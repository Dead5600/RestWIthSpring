package com.pro.service;

import java.util.List;

import com.pro.entity.Movie;

public interface MovieService {
	
	public boolean addMovie(Movie movie);
	
	public List<Movie> getAllMovie();
	
	public Movie getMovie(int id);
	
	public boolean deleteMovie(int id);
	
	public boolean updateMovie(int id, Movie movie);
	

}
