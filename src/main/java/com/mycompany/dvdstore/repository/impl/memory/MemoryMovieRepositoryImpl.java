package com.mycompany.dvdstore.repository.impl.memory;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryMovieRepositoryImpl implements MovieRepository {

    private static long cpt = 0;

    private List<Movie> movies = new ArrayList<>();

    public Movie addMovie(Movie movie){
        movie.setId(++cpt);
        movies.add(movie);
        System.out.println("[MemoryMovieRepositoryImpl] : The movie " + movie.getTitle() + " has been added.");
        return movie;
    }

    @Override
    public List<Movie> list() {
        return movies;
    }

    @Override
    public Movie getById(Long id) {
        return movies.stream().
                     filter(m -> m.getId()==id).
                     findFirst().get();
    }

}
