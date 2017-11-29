package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.Objects;

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
    private int startTime;

    /**
     * Duration of the HourBlock, can only be set to 1, 2, or 3.
     */
    private int duration;

    /**
     * Hour block default constructor.
     */
    public HourBlock() {
        startTime = EARLIEST_START_TIME;
        duration = MIN_BLOCK_DURATION;
    }

    /**
     * Hour block constructor.
     *
     * @param newStartTime the start time
     * @param newDuration the duration
     * @throws IllegalArgumentException if start time or duration are invalid
     */
    public HourBlock(final int newStartTime, final int newDuration) {
        if (newStartTime > LATEST_START_TIME
                || newStartTime < EARLIEST_START_TIME) {
            throw new IllegalArgumentException(
                    "Start Time must be an integer between 6 and 20");
        }
        this.startTime = newStartTime;

        if (newDuration < MIN_BLOCK_DURATION
                || newDuration > MAX_BLOCK_DURATION) {
            throw new IllegalArgumentException(
                    "Duration must be an integer between 1 and 3");
        }
        this.duration = newDuration;
    }

    /**
     * Sets the id of an HourBlock instance.
     *
     * @param newId New id for the Hours
     */
    public void setId(final String newId) {
        this.id = newId;
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
     * @param newStartTime the start time
     * @throws IllegalArgumentException if HourBlock < 6 or > 20
     */
    public void setStartTime(final int newStartTime)
            throws IllegalArgumentException {
        if (newStartTime > LATEST_START_TIME
                || newStartTime < EARLIEST_START_TIME) {
            throw new IllegalArgumentException(
                    "Start Time must be an integer between 6 and 20");
        }
        this.startTime = newStartTime;
    }

    /**
     * Gets the duration of the HourBlock.
     *
     * @return duration of the HourBlock
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the HourBlock.
     *
     * @param newDuration the duration
     * @throws IllegalArgumentException if duration is not 1, 2, or 3
     */
    public void setDuration(final int newDuration)
            throws IllegalArgumentException {
        if (newDuration < MIN_BLOCK_DURATION
                || newDuration > MAX_BLOCK_DURATION) {
            throw new IllegalArgumentException(
                    "Duration must be an integer between 1 and 3");
        }
        this.duration = newDuration;
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
        return startTime == hourBlock.startTime
                && duration == hourBlock.duration;
    }

    /**
     * hashCode method for HourBlock.
     */
    @Override
    public int hashCode() {
        return Objects.hash(startTime, duration);
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
                && this.getStartTime() + this.duration > hourBlock
                .getStartTime()) {
            return true;
        }

        if (hourBlock.getStartTime() < this.getStartTime()
                && hourBlock.getStartTime() + hourBlock.duration > this
                .getStartTime()) {
            return true;
        }

        return false;
    }

    /**
     * Get a readable version of the HourBlock fields.
     *
     * @return String of fields from the HourBlock object
     */
    @Override
    public String toString() {
        return "HourBlock{id = " + id + ", startTime = " + startTime
                + ", duration = " + duration + "}";
    }
}
