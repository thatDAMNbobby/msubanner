package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The msubanner application.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"edu"})
public class MsubannerApplication {

    /**
     * Starts the spring application.
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(MsubannerApplication.class, args);
    }
}
