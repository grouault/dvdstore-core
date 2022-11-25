package com.mycompany.dvdstore.service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.util.List;

public interface MovieService {

    void setMovieRepository(MovieRepository movieRepository);

    Movie registerMovie(Movie movie);

    List<Movie> getMovieList();

    Movie getMovieById(Long id);

}
