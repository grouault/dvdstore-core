package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import com.mycompany.dvdstore.repository.MovieRepository;
import com.mycompany.dvdstore.repository.impl.FileMovieRepositoryImpl;
import com.mycompany.dvdstore.service.MovieService;
import com.mycompany.dvdstore.service.impl.DefaultMovieServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MovieController movieController = applicationContext.getBean(MovieController.class);
        movieController.addUsingConsole();
    }
}
