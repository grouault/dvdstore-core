package com.mycompany.dvdstore.repository.impl;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.io.FileWriter;
import java.io.IOException;

public class FileMovieRepositoryImpl implements MovieRepository {

    public void addMovie(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter("C:\\tmp\\dvdstore\\dvdstore.txt",true);
            writer.write(movie.getTitle() + ":" + movie.getGenre() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("[FileMovieRepositoryImpl] : The movie " + movie.getTitle() + " has been added.");
    }

}
