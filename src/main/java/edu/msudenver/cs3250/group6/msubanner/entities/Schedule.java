package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * The schedule class.
 */
public class Schedule {
    /**
     * Schedule id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(unique = true)
    private String myId;

    /**
     * Name of the schedule.
     */
    @Column
    private String scheduleName;

    /** The room. */
    @DBRef
    private Room myRoom;

    /** The building. */
    @DBRef
    private Building myBuilding;

    /** The semester. */
    private Semester mySemester;

    /**
     * stores the date in this field. format is {code YYYY/MM/DD }
     */
    private String myStartDate;

    /**
     * number of weeks.
     */
    private int myDuration;

    /**
     * stores the days this schedule is for Example: Monday = M, Tuesday = T,
     * etc. An example that is Mon-Fri would be "MTWRF" Just tues/thursday would
     * be "TR"
     */
    private List<Days.Day> myDays;

    /**
     * time of class. Format is HH:MM AM/PM to HH:MM AM/PM Example 02:00 AM to
     * 03:50 AM
     */
    private String myHours;

    /** The Schedule's hour block. */
    @DBRef
    private HourBlock myHourBlock;

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
            final List<Days.Day> days, final String hours) {
        // Set up checks
        this.myRoom = room;
        this.myBuilding = building;
        this.mySemester = semester;
        this.myStartDate = startDate;
        this.myDays = days;
        this.myHours = hours;

        if (duration < 1) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.myDuration = duration;
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
            final List<Days.Day> days, final HourBlock hours) {
        // Set up checks
        this.myRoom = room;
        this.myBuilding = building;
        this.mySemester = semester;
        this.myStartDate = startDate;
        this.myDays = days;
        // this.hours = hours;
        this.myHourBlock = hours;

        if (duration < 1) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.myDuration = duration;
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
    public List<Days.Day> getDays() {
        return myDays;
    }

    /**
     * Sets the days of the schedule.
     *
     * @param days New id for the schedule
     */
    public void setDays(final List<Days.Day> days) {
        this.myDays = days;
    }

    /**
     * Returns the semester of the schedule.
     *
     * @return semester of the schedule
     */
    public Semester getSemester() {
        return mySemester;
    }

    /**
     * Sets the semester of the schedule.
     *
     * @param semester New id for the schedule
     */
    public void setSemester(final Semester semester) {
        this.mySemester = semester;
    }

    /**
     * Returns the id number of the schedule.
     *
     * @return id number of the schedule
     */
    public String getId() {
        return myId;
    }

    /**
     * Returns the startDate of the schedule.
     *
     * @return startDate of the schedule
     */
    public String getStartDate() {
        return myStartDate;
    }

    /**
     * Sets the startDate of the schedule.
     *
     * @param startDate New id for the schedule
     */
    public void setStartDate(final String startDate) {
        this.myStartDate = startDate;
    }

    /**
     * Sets the id of the schedule.
     *
     * @param id New id for the schedule
     */
    public void setId(final String id) {
        this.myId = id;
    }

    /**
     * Returns the course this section belongs to.
     *
     * @return course this section belongs to
     */
    public Room getRoom() {
        return myRoom;
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
        this.myRoom = room;
    }

    /**
     * Returns the building of this schedule.
     *
     * @return the building of this schedule
     */
    public Building getBuilding() {
        return myBuilding;
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
        this.myBuilding = building;
    }

    /**
     * Returns the schedule hours.
     *
     * @return hours of this schedule
     */
    public String getHours() {
        return myHours;
    }

    /**
     * Sets the schedule hours.
     *
     * @param hours new hours for this schedule
     */
    public void setHours(final String hours) {
        this.myHours = hours;
    }

    /**
     * Returns the schedule duration.
     *
     * @return duration of this schedule
     */
    public int getDuration() {
        return myDuration;
    }

    /**
     * Sets the schedule hours.
     *
     * @param duration new hours for this schedule
     */
    public void setDuration(final int duration) {
        this.myDuration = duration;
    }

    /**
     * Gets the hour block.
     *
     * @return the hour block
     */
    public final HourBlock getHourBlock() {
        return myHourBlock;
    }

    /**
     * Sets the hour block.
     *
     * @param hourBlock the hour block
     */
    public final void setHourBlock(final HourBlock hourBlock) {
        this.myHourBlock = hourBlock;
    }

    /**
     * Gets the schedule name.
     *
     * @return String the name of the schedule
     */
    public String getScheduleName() {
        return this.scheduleName;
    }

    /**
     * Sets the name of the schedule.
     */
    @Column
    private String myScheduleName;

    /**
     * Sets the name of the schedule.
     *
     * @param scheduleName New scheduleName of the schedule.
     * @throws IllegalArgumentException if new scheduleName is blank
     */
    public void setScheduleName(final String scheduleName)
            throws IllegalArgumentException {
        if (scheduleName == null || scheduleName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Schedule name cannot be blank.");
        }
        this.myScheduleName = scheduleName;
    }

    /**
     * Returns the Schedule as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", Room=" + room.getRoomNumber() +
                ", building:" + building.getBuildingName() +
                ", semester: " + semester.toString() +
                ", startDate:" + this.getStartDate() +
                ", duration:" + this.getDuration() +
                ", days:" + this.getDays() +
                ", hours:" + this.getHours() +
                ", hourBlock:" + hourBlock.toString() +
                '}';
    }

}
