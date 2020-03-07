package com.ucm.movielist.dto;
//for UI
public class MovieDto {
	
	private int id;
	private String movieName;
	private String year;
	
	public MovieDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieDto(int id, String movieName, String year) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
