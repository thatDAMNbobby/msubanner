package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent HourBlock class
 */

public class HourBlock {
    /**
     * HourBlock id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Start time of the HourBlock. Integer between 6 and 20 represents 6am to 8pm.
     */
    private int startTime;

    /**
     * Duration of the HourBlock, can only be set to 1, 2, or 3.
     */
    private int duration;

    /**
     * Sets the id of an HourBlock instance.
      * @param id New id for the Hours
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the id number of the Hours instance.
     *
     * @return id number of the HourBlock
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the startTime of HourBlock.
     *
     * @return start time of the HourBlock
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Sets the startTime of HourBlock.
     *
     * @throws IllegalArgumentException if HourBlock < 6 or > 20
     */
    public void setStartTime(int startTime) throws IllegalArgumentException {
        if(startTime > 20 || startTime < 6) {
            throw new IllegalArgumentException("Start Time must be an integer between 6 and 20");
        }
        this.startTime = startTime;
    }

    /**
     * Gets the duration of the HourBlock
     *
     * @return duration of the HourBlock
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the HourBlock
     *
     * @param duration
     * @throws IllegalArgumentException if duration is not 1, 2, or 3
     */
    public void setDuration(int duration) throws IllegalArgumentException {
        if(duration < 1 || duration >3) {
            throw new IllegalArgumentException("Duration must be an integer between 1 and 3");
        }
        this.duration = duration;
    }

    /**
     * equals method for HourBlock tests if startTime and Duration are equal
     */
    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof HourBlock)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        HourBlock hourBlock = (HourBlock) o;
        return this.getStartTime() == hourBlock.getStartTime() &&
               this.getDuration()  == hourBlock.getDuration();
    }

    /**
     * hasConflict method - checks to see if there is a conflict with another HourBlock
     *   using the logic "if lowerStartTime + duration > higherStartTime, then conflict"
     */
    public boolean hasConflict(final Object o) {
        if (o == null || !(o instanceof HourBlock)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        HourBlock hourBlock = (HourBlock) o;
        if(this.getStartTime() == hourBlock.getStartTime()) return true;

        if(this.getStartTime() < hourBlock.getStartTime() && this.getStartTime() + this.duration > hourBlock.getStartTime()) {
            return true;
        }

        if(hourBlock.getStartTime() < this.getStartTime() && hourBlock.getStartTime() + hourBlock.duration > this.getStartTime()) {
            return true;
        }

        return false;
    }
}
