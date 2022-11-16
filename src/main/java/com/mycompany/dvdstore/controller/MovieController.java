package com.mycompany.dvdstore.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieService;
import java.util.Scanner;

public class MovieController {

    private MovieService movieService = new MovieService();

    public void addUsingConsole(){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter title of Movie:");
        String title = in.nextLine();
        System.out.println("Enter genre of Movie:");
        String genre = in.nextLine();

        // create Movie
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);

        movieService.registerMovie(movie);

    }

}
