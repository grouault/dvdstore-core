package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;

public interface MovieService {

    void setMovieRepository(MovieRepository movieRepository);

    void registerMovie(Movie movie);
}
