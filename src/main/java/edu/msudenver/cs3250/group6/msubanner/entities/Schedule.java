package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * The schedule class.
 */
public class Schedule {
    /**
     * Schedule id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** The room. */
    @DBRef
    private Room room;

    /** The building. */
    @DBRef
    private Building building;

    private Semester semester;

    /**
     * stores the date in this field. format is {code YYYY/MM/DD }
     */
    private String startDate;

    /**
     * number of weeks.
     */
    private int duration;

    /**
     * stores the days this schedule is for Example: Monday = M, Tuesday = T,
     * etc. An example that is Mon-Fri would be "MTWRF" Just tues/thursday would
     * be "TR"
     */
    private List<Day> days;

    /**
     * time of class. Format is HH:MM AM/PM to HH:MM AM/PM Example 02:00 AM to
     * 03:50 AM
     */
    private String hours;

    /** */
    @DBRef
    private HourBlock hourBlock;

    /**
     * Default constructor.
     */
    public Schedule() {
    }
  
    /**
     * Schedule constructor.
     *
     * @param room the room
     * @param building the building
     * @param semester the semester
     * @param startDate the start date
     * @param duration the duration
     * @param days the days
     * @param hours the hours.
     */
    public Schedule(final Room room, final Building building,
            final Semester semester, final String startDate, final int duration,
            final List<Day> days, final String hours) {
        // Set up checks
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
         * if (roomCapacity < 0) { throw new
         * IllegalArgumentException("Stay positive"); } else { capacity =
         * roomCapacity; }
         */
    }

    /**
     * Schedule constructor.
     *
     * @param room the room
     * @param building the building
     * @param semester the semester
     * @param startDate the start date
     * @param duration the duration
     * @param days the days
     * @param hours the hours
     */
    public Schedule(final Room room, final Building building,
            final Semester semester, final String startDate, final int duration,
            final List<Day> days, final HourBlock hours) {
        // Set up checks
        this.room = room;
        this.building = building;
        this.semester = semester;
        this.startDate = startDate;
        this.days = days;
        // this.hours = hours;
        hourBlock = hours;

        if (duration < 1) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.duration = duration;
        }

        /*
         * if (roomCapacity < 0) { throw new
         * IllegalArgumentException("Stay positive"); } else { capacity =
         * roomCapacity; }
         */
    }

    /**
     * Returns the days of the schedule.
     *
     * @return days of the schedule
     */
    public List<Day> getDays() {
        return days;
    }

    /**
     * Sets the days of the schedule.
     *
     * @param days New id for the schedule
     */
    public void  setDays(final List<Day> days) { this.days = days; }

    /**
     * Returns the semester of the schedule.
     *
     * @return semester of the schedule
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     * Sets the semester of the schedule.
     *
     * @param semester New id for the schedule
     */
    public void setSemester(final Semester semester) {
        this.semester = semester;
    }

    /**
     * Returns the id number of the schedule.
     *
     * @return id number of the schedule
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the startDate of the schedule.
     *
     * @return startDate of the schedule
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the startDate of the schedule.
     *
     * @param startDate New id for the schedule
     */
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
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
     * Returns the course this section belongs to.
     *
     * @return course this section belongs to
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the course this section belongs to.
     *
     * @param room new course for this section
     * @throws IllegalArgumentException if the room is null
     */
    public void setRoom(final Room room) throws IllegalArgumentException {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null!");
        }
        this.room = room;
    }

    /**
     * Returns the building of this schedule.
     *
     * @return the building of this schedule
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * Sets the building of this schedule.
     *
     * @param building new professor for this section
     * @throws IllegalArgumentException if the professor is null
     */
    public void setBuilding(final Building building)
            throws IllegalArgumentException {
        if (building == null) {
            throw new IllegalArgumentException("Building cannot be null!");
        }
        this.building = building;
    }

    /**
     * Returns the schedule hours.
     *
     * @return hours of this schedule
     */
    public String getHours() {
        return hours;
    }

    /**
     * Sets the schedule hours.
     *
     * @param hours new hours for this schedule
     */
    public void setHours(final String hours) {
        this.hours = hours;
    }

    /**
     * Returns the schedule duration.
     *
     * @return duration of this schedule
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the schedule hours.
     *
     * @param duration new hours for this schedule
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * Gets the hour block.
     *
     * @return the hour block
     */
    public final HourBlock getHourBlock() {
        return hourBlock;
    }

    /**
     * Sets the hour block.
     *
     * @param hourBlock the hour block
     */
    public final void setHourBlock(final HourBlock hourBlock) {
        this.hourBlock = hourBlock;
    }

    /**
     * Returns if one schedule is equal to another.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof Schedule)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        final Schedule otherSchedule = (Schedule) other;
        return this.getId().equals(otherSchedule.getId())
                && this.getRoom().equals(otherSchedule.getRoom())
                && this.getBuilding().equals(otherSchedule.getBuilding());
    }

    /**
     * Name of the building.
     */
    @Column
    private String scheduleName;

    /**
     * Sets the name of the building.
     *
     * @param scheduleName New scheduleName of the schedule.
     * @throws IllegalArgumentException if new scheduleName is blank
     */
    public void setScheduleName(final String scheduleName)
            throws IllegalArgumentException {
        if (scheduleName == null || scheduleName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Building name cannot be blank.");
        }
        this.scheduleName = scheduleName;
    }

    /**
     * Returns the Schedule as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", Room=" + room.toString()
                + ", building:" + building.toString() + '}';
    }

}
