package com.mycompany.dvdstore.repository.impl;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;

public class FileMovieRepositoryImpl implements MovieRepository {

    @Value("${movies.file.location}")
    private File file;

    public void addMovie(Movie movie){
        FileWriter writer;
        try{
            writer=new FileWriter(file,true);
            writer.write(movie.getTitle() + ":" + movie.getGenre() + "\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("[FileMovieRepositoryImpl] : The movie " + movie.getTitle() + " has been added.");
    }

}
