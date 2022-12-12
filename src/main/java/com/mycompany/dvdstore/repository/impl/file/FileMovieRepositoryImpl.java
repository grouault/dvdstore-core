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
public class FileMovieRepositoryImpl implements MovieRepository {

    @Value("${movies.file.location}")
    private File file;

    public Movie addMovie(Movie movie){
        FileWriter writer;
        try{
            long lastId=list().stream().map(Movie::getId).max(Long::compare).orElse(0L);
            movie.setId(lastId+1);
            writer=new FileWriter(file,true);
            writer.write(movie.getId()+";"+movie.getTitle()+";"+movie.getGenre()+";"+movie.getDescription()+"\n");
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("[FileMovieRepositoryImpl] : The movie " + movie.getTitle() + " has been added.");
        return movie;
    }

    @Override
    public List<Movie> list() {

        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] values = line.split("\\;");
                movie.setId(Long.parseLong(values[0]));
                movie.setTitle(values[1]);
                movie.setGenre(values[2]);
                movie.setDescription(values[3]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getById(Long id) {
        final Movie movie = new Movie();
        movie.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split("\\;");
                final long nextMovieId=Long.parseLong(allProperties[0]);
                if (nextMovieId==id) {
                    movie.setTitle(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);
                    return movie;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the file does not have a proper id");
            e.printStackTrace();
        }
        movie.setTitle("UNKNOWN");
        movie.setGenre("UNKNOWN");
        movie.setDescription("UNKNOWN");
        return movie;
    }

}
