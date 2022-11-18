package com.mycompany.dvdstore.repository.impl;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;

public class MemoryMovieRepositoryImpl implements MovieRepository {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
        System.out.println("[MemoryMovieRepositoryImpl] : The movie " + movie.getTitle() + " has been added.");
    }

}
