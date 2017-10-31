package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

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
     * ArrayList of Day enums
     */
    private ArrayList<Day> dayList = new ArrayList<Day>();

    /**
     * Valid Day to populate dayList
     */
    private enum Day {
        MONDAY("Monday");

        private String dayName;

        Day(final String dayName) {
            this.dayName = dayName;
        }
    }

    public void addDayToDays() {

    }

    /**
     * Sets the id of an Days instance.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the id of the Days
     *
     * @return String id number of the Days
     */
    public String getId() { return id; }


}

