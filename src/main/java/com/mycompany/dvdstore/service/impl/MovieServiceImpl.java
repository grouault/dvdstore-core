package com.mycompany.dvdstore.service.impl;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.entity.repository.MovieRepository;
import com.mycompany.dvdstore.entity.repository.impl.GoLiveMovieRepository;
import com.mycompany.dvdstore.service.MovieService;

public class MovieServiceImpl implements MovieService {

    private static int counter = 0;

    private MovieRepository movieRepository;

    public void registerMovie(Movie movie) {
        movie.setId(++counter);
        movieRepository.addMovie(movie);
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

}
