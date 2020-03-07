package com.ucm.movielist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ucm.movielist.model.Movie;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Integer>{
}
