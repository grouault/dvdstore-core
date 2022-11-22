package com.mycompany.dvdstore.repository.impl.file;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.MovieRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
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

    @Override
    public List<Movie> list() {

        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\:");
                movie.setTitle(titreEtGenre[0]);
                movie.setGenre(titreEtGenre[1]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }


}
