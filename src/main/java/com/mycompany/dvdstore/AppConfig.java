package com.mycompany.dvdstore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
        "com.mycompany.dvdstore.controller",
        "com.mycompany.dvdstore.service",
        "com.mycompany.dvdstore.repository.impl.file"
})
@PropertySource("classpath:application.properties")
public class AppConfig {
}
