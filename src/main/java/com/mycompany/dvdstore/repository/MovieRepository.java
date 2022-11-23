package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import java.util.List;

public interface MovieRepository {

    void addMovie(Movie movie);

    List<Movie> list();

    Movie getById(Long id);
}
