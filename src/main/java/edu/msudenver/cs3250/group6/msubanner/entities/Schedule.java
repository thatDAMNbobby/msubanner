package edu.msudenver.cs3250.group6.msubanner.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Schedule {
    /**
     * Schedule id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @DBRef
    private Room room;

    @DBRef
    private Building building;

    private String semester;
    /**
     * stores the date in this field.
     * format is {code YYYY/MM/DD }
    */
    private String startDate;
    public String getStartDate() { return startDate; }
    /**
    * number of weeks
    */
    private int duration;

    /**
     * stores the days this schedule is for
     * Example: Monday =  M, Tuesday = T, etc.
     * An example that is Mon-Fri would be "MTWRF"
     * Just tues/thursday would be "TR"
     */
    private String days;

    /**
     * time of class
     * Format is HH:MM AM/PM to HH:MM AM/PM
     * Example 02:00 AM to 03:50 AM
     */
    private String hours;

    public Schedule(Room room, Building building, String semester, String startDate, int duration, String days, String hours) {
       //Set up checks
        this.room = room;
        this.building = building;
        this.semester = semester;
        this.startDate = startDate;
        this.days = days;
        this.hours = hours;

        if (duration < 1) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.duration = duration;
        }

        /*
        if (roomCapacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            capacity = roomCapacity;
        }*/
    }
    /**
     * Sets the id of the schedule.
     *
     * @param id New id for the schedule
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Returns the id number of the schedule.
     *
     * @return id number of the schedule
     */
    public String getId() {
        return id;
    }



}
