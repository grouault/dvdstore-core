package com.mycompany.dvdstore.service.impl;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultMovieServiceImpl implements MovieService {

    private int counter = 0;

    @Autowired
    private MovieRepository movieRepository;

    public void registerMovie(Movie movie) {
        movie.setId(++counter);
        movieRepository.addMovie(movie);
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

}
