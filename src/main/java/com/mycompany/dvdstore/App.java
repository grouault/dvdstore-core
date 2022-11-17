package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.entity.repository.MovieRepository;
import com.mycompany.dvdstore.entity.repository.impl.FileMovieRepositoryImpl;
import com.mycompany.dvdstore.service.MovieService;
import com.mycompany.dvdstore.service.impl.DefaultMovieServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        MovieController movieController = new MovieController();
        MovieService movieService = new DefaultMovieServiceImpl();
        movieController.setMovieService(movieService);
        MovieRepository movieRepository = new FileMovieRepositoryImpl();
        movieService.setMovieRepository(movieRepository);

        movieController.addUsingConsole();
    }
}
