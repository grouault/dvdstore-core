package com.mycompany.dvdstore.service.impl;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultMovieServiceImpl implements MovieService {

    private int counter = 0;

    @Autowired
    private MovieRepository movieRepository;

    public void registerMovie(Movie movie) {
        movie.setId(Long.valueOf((++counter)));
        movieRepository.addMovie(movie);
    }

    @Override
    public List<Movie> getMovieList() {
        return movieRepository.list();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.getById(id);
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

}
