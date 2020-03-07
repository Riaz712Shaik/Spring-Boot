package com.ucm.movielist.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucm.movielist.dto.MovieDto;
import com.ucm.movielist.model.Movie;
import com.ucm.movielist.repository.MovieRepository;
import com.ucm.movielist.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	private Movie convertDtoToModel(MovieDto movieDto) {
		Movie movie = new Movie();
		if (movieDto != null) {
			movie.setId(movieDto.getId());
		}
		movie.setMovieName(movieDto.getMovieName());
		movie.setYear(movieDto.getYear());
		return movie;
	}

	private MovieDto convertModelToDTO(Movie movie) {
		MovieDto movieDto = new MovieDto();
		movieDto.setId(movie.getId());
		movieDto.setMovieName(movie.getMovieName());
		movieDto.setYear(movie.getYear());
		return movieDto;
	}

	@Override
	public void createMovie(MovieDto movieDto) {
		Movie movie = convertDtoToModel(movieDto);
		movieRepository.save(movie);
	}

	@Override
	public List<MovieDto> getAllMovies() {
		List<Movie> list = movieRepository.findAll();
		List<MovieDto> movieDtoList = new ArrayList<MovieDto>();
		list.stream().forEach(movie -> {
			movieDtoList.add(convertModelToDTO(movie));
		});
		return movieDtoList;
	}

	@Override
	public void deletemovie(int id) {

		movieRepository.deleteById(id);

	}

	@Override
	public MovieDto editMovieDetails(int id) {
		Movie movie = movieRepository.getOne(id);
		return convertModelToDTO(movie);
	}

	@Override
	public MovieDto search(String movieName) {
		List<Movie> list = movieRepository.findAll();
		Movie movie=(Movie) list.stream().filter(m -> m.getMovieName().equalsIgnoreCase(movieName)).findAny().orElse(new Movie());
		return convertModelToDTO(movie);
	}
}
