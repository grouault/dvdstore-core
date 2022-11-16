package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.GoLiveMovieRepository;
import com.mycompany.dvdstore.repository.MovieRepository;

public class MovieService {

    private static int counter = 0;

    private GoLiveMovieRepository movieRepository = new GoLiveMovieRepository();

    public void registerMovie(Movie movie) {
        movie.setId(++counter);
        movieRepository.add(movie);
    }

}
