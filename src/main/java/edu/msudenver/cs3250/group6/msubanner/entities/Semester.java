package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Semester class.
 */
public class Semester {

    /**
     * Semester id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Sets the id of a Semester instance.
     * @param id New id for the Semester
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the id number of the Semester instance.
     *
     * @return id number of the Semester
     */
    public String getId() {
        return id;
    }
}
