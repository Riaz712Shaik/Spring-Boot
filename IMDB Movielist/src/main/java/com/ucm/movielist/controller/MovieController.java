package com.ucm.movielist.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucm.movielist.dto.MovieDto;
import com.ucm.movielist.model.Movie;
import com.ucm.movielist.service.MovieService;



@Controller
public class MovieController {

	@Autowired
	private MovieService movieservice;
	
	@GetMapping("/")
	public String defaultPage(Map<String, Object> model) {
		return "redirect:/list";
	}
	
	@PostMapping("/addMovie")
	public String addMovie(@ModelAttribute("movie") MovieDto movieDto) {
		movieservice.createMovie(movieDto);
		return "redirect:/list";	
	}
	
	@GetMapping("/editMovie")
	public String editMovie(@RequestParam("id") String id, Map<String, Object> model) {
		MovieDto movie = movieservice.editMovieDetails(Integer.parseInt(id));
		model.put("movie", movie);
		return "updateMovie";
	}
	
	
	@GetMapping("/list") 
	public String listMovies(Model model) {
		List<MovieDto> movieList = movieservice.getAllMovies();
		model.addAttribute("movieList", movieList);
		model.addAttribute("movie", new Movie());
		return "movieList";
	}
	
	@GetMapping("/delete")
	public String deleteMovie(@RequestParam("id") String id) {
		movieservice.deletemovie(Integer.parseInt(id));
		return "redirect:/list";		
	}
	
	@GetMapping("/search")
	public String searchMovie(@RequestParam("search") String serchValue, Model model) {
		if(serchValue == null || serchValue.isEmpty()) {
			return "redirect:/list";
		}else {
			List<MovieDto> movieList = new ArrayList<MovieDto>();
			MovieDto mv = movieservice.search(serchValue);
			movieList.add(mv);
			
			model.addAttribute("movieList", movieList);
			model.addAttribute("movie", new Movie());
			return "movieList";
		}
		
	}
	
}
