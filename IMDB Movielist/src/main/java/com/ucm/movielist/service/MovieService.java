package com.ucm.movielist.service;

import java.util.List;

import com.ucm.movielist.dto.MovieDto;
//encapsulating 
public interface MovieService {

	public void createMovie(MovieDto movieDto);
	
	public List<MovieDto> getAllMovies();
	
	public void deletemovie(int id);
	
	public MovieDto editMovieDetails(int id);
	
	public MovieDto search(String movieName);
	
}
