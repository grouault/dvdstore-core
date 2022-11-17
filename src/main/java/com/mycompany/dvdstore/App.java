package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.entity.repository.MovieRepository;
import com.mycompany.dvdstore.entity.repository.impl.GoLiveMovieRepository;
import com.mycompany.dvdstore.entity.repository.impl.MovieRepositoryImpl;
import com.mycompany.dvdstore.service.MovieService;
import com.mycompany.dvdstore.service.impl.MovieServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        MovieController movieController = new MovieController();
        MovieService movieService = new MovieServiceImpl();
        movieController.setMovieService(movieService);
        MovieRepository movieRepository = new GoLiveMovieRepository();
        movieService.setMovieRepository(movieRepository);

        movieController.addUsingConsole();
    }
}
