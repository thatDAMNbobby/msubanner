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

    public void setDays(String days) {
        this.days = days;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
        return this.getId() == otherSchedule.getId()
                && this.getRoom().equals(otherSchedule.getRoom())
                && this.getBuilding().equals(otherSchedule.getBuilding());
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

