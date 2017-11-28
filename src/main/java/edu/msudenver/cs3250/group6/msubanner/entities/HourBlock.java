package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent HourBlock class.
 */

public class HourBlock {
    /** The earliest start time possible - represented by an int. */
    private static final int EARLIEST_START_TIME = 6;

    /** The latest start time possible - represented by an int. */
    private static final int LATEST_START_TIME = 20;

    /** The minimum hours in an hour block. */
    private static final int MIN_BLOCK_DURATION = 1;

    /** The maximum hours in an hour block. */
    private static final int MAX_BLOCK_DURATION = 3;

    /**
     * HourBlock id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Start time of the HourBlock. Integer between 6 and 20 represents 6am to
     * 8pm.
     */
    private int myStartTime;

    /**
     * Duration of the HourBlock, can only be set to 1, 2, or 3.
     */
    private int myDuration;

    /**
     * Hour block default constructor.
     */
    public HourBlock() {
        myStartTime = EARLIEST_START_TIME;
        myDuration = MIN_BLOCK_DURATION;
    }

    /**
     * Hour block constructor.
     *
     * @param startTime the start time
     * @param duration the duration
     */
    public HourBlock(final int startTime, final int duration) {
        this.myStartTime = startTime;
        this.myDuration = duration;
    }

    /**
     * Sets the id of an HourBlock instance.
     *
     * @param id New id for the Hours
     */
    public void setId(final String id) {
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
        return myStartTime;
    }

    /**
     * Sets the startTime of HourBlock.
     *
     * @param startTime the start time
     * @throws IllegalArgumentException if HourBlock < 6 or > 20
     */
    public void setStartTime(final int startTime)
            throws IllegalArgumentException {
        if (startTime > LATEST_START_TIME || startTime < EARLIEST_START_TIME) {
            throw new IllegalArgumentException(
                    "Start Time must be an integer between 6 and 20");
        }
        this.myStartTime = startTime;
    }

    /**
     * Gets the duration of the HourBlock.
     *
     * @return duration of the HourBlock
     */
    public int getDuration() {
        return myDuration;
    }

    /**
     * Sets the duration of the HourBlock.
     *
     * @param duration the duration
     * @throws IllegalArgumentException if duration is not 1, 2, or 3
     */
    public void setDuration(final int duration)
            throws IllegalArgumentException {
        if (duration < MIN_BLOCK_DURATION || duration > MAX_BLOCK_DURATION) {
            throw new IllegalArgumentException(
                    "Duration must be an integer between 1 and 3");
        }
        this.myDuration = duration;
    }

    /**
     * equals method for HourBlock tests if startTime and Duration are equal.
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
        return this.getStartTime() == hourBlock.getStartTime()
                && this.getDuration() == hourBlock.getDuration();
    }

    /**
     * checks to see if there is a conflict with another HourBlock. using the
     * logic "if lowerStartTime + duration > higherStartTime, then conflict"
     *
     * @param o the object to compare with
     * @return if there is a conflict
     */
    public boolean hasConflict(final Object o) {
        if (o == null || !(o instanceof HourBlock)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        HourBlock hourBlock = (HourBlock) o;
        if (this.getStartTime() == hourBlock.getStartTime()) {
            return true;
        }

        if (this.getStartTime() < hourBlock.getStartTime()
                && this.getStartTime() + this.myDuration > hourBlock
                        .getStartTime()) {
            return true;
        }

        if (hourBlock.getStartTime() < this.getStartTime()
                && hourBlock.getStartTime() + hourBlock.myDuration > this
                        .getStartTime()) {
            return true;
        }

        return false;
    }

    /**
     * Get a readable version of the HourBlock fields
     *
     * @return String of fields from the HourBlock object
     */
    @Override
    public String toString() {
        return "HourBlock{" +
                "id='" + id + '\'' +
                ", startTime=" + myStartTime +
                ", duration=" + myDuration +
                '}';
    }
}
