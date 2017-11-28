package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Persistent Section class.
 */

public class Section {

    /** Section's Id number. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** Course this section belongs to. */
    @DBRef
    private Course myCourse;

    /** Section's professor. */
    @DBRef
    private Professor professor;

    /** Section's schedule. */
    @DBRef
    private Schedule mySchedule;

    /**
     * Default constructor, creates a blank section.
     */
    public Section() {

    }

    /**
     * Creates a new section and instantiates the course and professor fields.
     *
     * @param course The course that this section belongs to
     * @param professor The professor for this section
     * @param schedule the schedule
     */
    public Section(final Course course, final Professor professor,
            final Schedule schedule) throws IllegalArgumentException {
        if (course != null) {
            this.myCourse = course;
        } else {
            throw new IllegalArgumentException("Course cannot be null");
        }
        if (professor != null) {
            this.professor = professor;
        } else {
            throw new IllegalArgumentException("Professor cannot be null");
        }
        if (schedule != null) {
            this.mySchedule = schedule;
        } else {
            throw new IllegalArgumentException("Schedule cannot be null");
        }
    }

    /**
     * Overloaded constructor - allows for creation without a professor.
     *
     * @param course the course
     * @throws IllegalArgumentException if course is null
     */
    public Section(final Course course) throws IllegalArgumentException {
        if (course != null) {
            this.myCourse = course;
        } else {
            throw new IllegalArgumentException("Course cannot be null");
        }
    }

    /**
     * Returns the section id number.
     *
     * @return id of this section
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the section id number.
     *
     * @param id new id number for this section
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Returns the course this section belongs to.
     *
     * @return course this section belongs to
     */
    public Course getCourse() {
        return myCourse;
    }

    /**
     * Sets the course this section belongs to.
     *
     * @param course new course for this section
     * @throws IllegalArgumentException if the course is null
     */
    public void setCourse(final Course course) throws IllegalArgumentException {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null!");
        }
        this.myCourse = course;
    }

    /**
     * Returns the professor of this section.
     *
     * @return the professor of this section
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Sets the professor of this section.
     *
     * @param professor new professor for this section
     * @throws IllegalArgumentException if the professor is null
     */
    public void setProfessor(final Professor professor)
            throws IllegalArgumentException {
        if (professor == null) {
            throw new IllegalArgumentException("Professor cannot be null!");
        }
        this.professor = professor;
    }

    /**
     * Returns the section's schedule.
     *
     * @return the schedule of this section
     */
    public Schedule getSchedule() {
        return mySchedule;
    }

    /**
     * Set's the section's schedule.
     *
     * @param schedule new schedule for this section
     */
    public void setSchedule(final Schedule schedule) throws IllegalArgumentException {
        if (schedule != null) {
            this.mySchedule = schedule;
        } else {
            throw new IllegalArgumentException("Course cannot be null");
        }

    }

    /**
     * Returns if one section is equal to another.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof Section)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        final Section otherSection = (Section) other;
        return this.getId().equals(otherSection.getId())
                && this.getCourse().equals(otherSection.getCourse())
                && this.getProfessor().equals(otherSection.getProfessor());
    }

    /**
     * Get the hashCode of a Section object
     *
     * @return hashCode of section object
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + myCourse.hashCode();
        result = 31 * result + professor.hashCode();
        result = 31 * result + mySchedule.hashCode();
        return result;
    }

    /**
     * Returns the Section as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", Course=" + myCourse.toString()
                + ", professor:" + professor.toString() + '}';
    }
}
