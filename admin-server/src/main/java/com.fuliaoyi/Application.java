package com.fuliaoyi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by leo on 17/1/24.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.fuliaoyi"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}