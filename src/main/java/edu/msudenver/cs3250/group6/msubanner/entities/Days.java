package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Days Class
 */
public class Days {


    /**
     * Days
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Sets the id of an Days instance.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
