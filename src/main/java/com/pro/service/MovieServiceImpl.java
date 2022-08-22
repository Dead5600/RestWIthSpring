package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.MovieDao;
import com.pro.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao dao;
	
	@Override
	public boolean addMovie(Movie movie) {
		return dao.addMovie(movie);
	}

	@Override
	public List<Movie> getAllMovie() {
		return dao.getAllMovie();
	}

	@Override
	public Movie getMovie(int id) {
		return dao.getMovie(id);
	}

	@Override
	public boolean deleteMovie(int id) {
		return dao.deleteMovie(id);
	}

	@Override
	public boolean updateMovie(int id, Movie movie) {
		return dao.updateMovie(id, movie);
	}

}
