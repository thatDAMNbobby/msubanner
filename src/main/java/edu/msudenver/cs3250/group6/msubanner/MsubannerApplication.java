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
public final class MsubannerApplication {

    /**
     * Starts the spring application.
     * @param args the args
     */
    public static void main(final String[] args) {
        SpringApplication.run(MsubannerApplication.class, args);
    }

    /**
     * Prevents instantiation of this class.
     */
    private MsubannerApplication() {
        throw new AssertionError("Instantiating a utility class");
    }
}
