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
    private String id;

    /**
     * Name of the schedule.
     */
    @Column
    private String scheduleName;

    /** The room. */
    @DBRef
    private Room room;

    /** The building. */
    @DBRef
    private Building building;

    /** The semester. */
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
    private List<Days.Day> days;

    /**
     * time of class. Format is HH:MM AM/PM to HH:MM AM/PM Example 02:00 AM to
     * 03:50 AM
     */
    private String timeOfClass;

    /** The Schedule's hour block. */
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
     * @param newRoom the room
     * @param newBuilding the building
     * @param newSemester the semester
     * @param newStartDate the start date
     * @param newDuration the duration
     * @param newDays the days
     * @param newTime the hours.
     */
    public Schedule(final Room newRoom, final Building newBuilding,
            final Semester newSemester, final String newStartDate,
            final int newDuration, final List<Days.Day> newDays,
            final String newTime) {
        // TODO: Set up checks
        this.room = newRoom;
        this.building = newBuilding;
        this.semester = newSemester;
        this.startDate = newStartDate;
        this.days = newDays;
        this.timeOfClass = newTime;

        if (newDuration < 1) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.duration = newDuration;
        }
    }

    /**
     * Schedule constructor.
     *
     * @param newRoom the room
     * @param newBuilding the building
     * @param newSemester the semester
     * @param newStartDate the start date
     * @param newDuration the duration
     * @param newDays the days
     * @param newHourBlock the hours
     */
    public Schedule(final Room newRoom, final Building newBuilding,
            final Semester newSemester, final String newStartDate,
            final int newDuration, final List<Days.Day> newDays,
            final HourBlock newHourBlock) {
        //TODO: Set up checks
        this.room = newRoom;
        this.building = newBuilding;
        this.semester = newSemester;
        this.startDate = newStartDate;
        this.days = newDays;
        //TODO: what's up with hours vs hourblock?
        // this.hours = hours;
        this.hourBlock = newHourBlock;

        if (newDuration < 1) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.duration = newDuration;
        }
    }

    /**
     * Returns the days of the schedule.
     *
     * @return days of the schedule
     */
    public List<Days.Day> getDays() {
        return days;
    }

    /**
     * Sets the days of the schedule.
     *
     * @param newDays New id for the schedule
     */
    public void setDays(final List<Days.Day> newDays) {
        this.days = newDays;
    }

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
     * @param newSemester New id for the schedule
     */
    public void setSemester(final Semester newSemester) {
        this.semester = newSemester;
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
     * @param newStartDate New id for the schedule
     */
    public void setStartDate(final String newStartDate) {
        this.startDate = newStartDate;
    }

    /**
     * Sets the id of the schedule.
     *
     * @param newId New id for the schedule
     */
    public void setId(final String newId) {
        this.id = newId;
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
     * @param newRoom new course for this section
     * @throws IllegalArgumentException if the room is null
     */
    public void setRoom(final Room newRoom) throws IllegalArgumentException {
        if (newRoom == null) {
            throw new IllegalArgumentException("Room cannot be null!");
        }
        this.room = newRoom;
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
     * @param newBuilding new professor for this section
     * @throws IllegalArgumentException if the professor is null
     */
    public void setBuilding(final Building newBuilding)
            throws IllegalArgumentException {
        if (newBuilding == null) {
            throw new IllegalArgumentException("Building cannot be null!");
        }
        this.building = newBuilding;
    }

    /**
     * Returns the schedule hours.
     *
     * @return hours of this schedule
     */
    public String getHours() {
        return timeOfClass;
    }

    /**
     * Sets the schedule hours.
     *
     * @param newTime new time for this schedule
     */
    public void setHours(final String newTime) {
        this.timeOfClass = newTime;
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
     * @param newDuration new hours for this schedule
     */
    public void setDuration(final int newDuration) {
        this.duration = newDuration;
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
     * @param newHourBlock the hour block
     */
    public final void setHourBlock(final HourBlock newHourBlock) {
        this.hourBlock = newHourBlock;
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
     *
     * @param newScheduleName New scheduleName of the schedule.
     * @throws IllegalArgumentException if new scheduleName is blank
     */
    public void setScheduleName(final String newScheduleName)
            throws IllegalArgumentException {
        if (newScheduleName == null || newScheduleName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Schedule name cannot be blank.");
        }
        this.scheduleName = newScheduleName;
    }

    /**
     * Returns the Schedule as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Schedule{id: " + id
                + ", room: " + room.getRoomNumber()
                + ", building: " + building.getBuildingName()
                + ", semester: " + semester.toString()
                + ", startDate: " + startDate
                + ", duration: " + duration
                + ", days: " + days
                + ", hours: " + timeOfClass
                + ", hourBlock: " + hourBlock.toString() + "}";
    }
}
