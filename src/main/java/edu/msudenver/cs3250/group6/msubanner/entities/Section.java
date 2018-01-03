package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.Objects;

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
    private Course course;

    /** Section's professor. */
    @DBRef
    private Professor professor;

    /** Section's schedule. */
    @DBRef
    private Schedule schedule;

    /** Section's student's */
    @DBRef
    private Student student;

    /**
     * Default constructor, creates a blank section.
     */
    public Section() {
    }

    /**
     * Creates a new section and instantiates the course and professor fields.
     *
     * @param newCourse The course that this section belongs to
     * @param newProf The professor for this section
     * @param newSchedule the schedule
     * @throws IllegalArgumentException if an invalid course, professor, or
     *         schedule are used
     */
    public Section(final Course newCourse, final Professor newProf,
            final Schedule newSchedule) throws IllegalArgumentException {
        if (newCourse != null) {
            this.course = newCourse;
        } else {
            throw new IllegalArgumentException("Course cannot be null");
        }
        if (newProf != null) {
            this.professor = newProf;
        } else {
            throw new IllegalArgumentException("Professor cannot be null");
        }
        if (newSchedule != null) {
            this.schedule = newSchedule;
        } else {
            throw new IllegalArgumentException("Schedule cannot be null");
        }
    }

    /**
     * Overloaded constructor - allows for creation without a professor.
     *
     * @param newCourse the course
     * @throws IllegalArgumentException if course is null
     */
    public Section(final Course newCourse) throws IllegalArgumentException {
        if (newCourse != null) {
            this.course = newCourse;
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
     * @param newId new id number for this section
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Returns the course this section belongs to.
     *
     * @return course this section belongs to
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the course this section belongs to.
     *
     * @param newCourse new course for this section
     * @throws IllegalArgumentException if the course is null
     */
    public void setCourse(final Course newCourse)
            throws IllegalArgumentException {
        if (newCourse == null) {
            throw new IllegalArgumentException("Course cannot be null!");
        }
        this.course = newCourse;
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
     * @param newProf new professor for this section
     * @throws IllegalArgumentException if the professor is null
     */
    public void setProfessor(final Professor newProf)
            throws IllegalArgumentException {
        if (newProf == null) {
            throw new IllegalArgumentException("Professor cannot be null!");
        }
        this.professor = newProf;
    }

    /**
     * Returns the student enrolled in this section.
     *
     * @return the student enrolled in this section
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student for this section.
     *
     * @param newStudent new student for this section
     * @throws IllegalArgumentException if the student is null
     */
    public void setStudent(final Student newStudent)
            throws IllegalArgumentException {
        if (newStudent == null) {
            throw new IllegalArgumentException("Student cannot be null!");
        }
        this.student = newStudent;
    }


    /**
     * Returns the section's schedule.
     *
     * @return the schedule of this section
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * Set's the section's schedule.
     *
     * @param newSchedule new schedule for this section
     * @throws IllegalArgumentException if the schedule is null
     */
    public void setSchedule(final Schedule newSchedule)
            throws IllegalArgumentException {
        if (newSchedule != null) {
            this.schedule = newSchedule;
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
        return Objects.equals(id, otherSection.id)
                && Objects.equals(course, otherSection.course)
                && Objects.equals(professor, otherSection.professor)
                && Objects.equals(schedule, otherSection.schedule);
    }

    /**
     * Get the hashCode of a Section object.
     *
     * @return hashCode of section object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, course, professor, schedule);
    }

    /**
     * Returns the Section as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Section{id = " + id + ", Course = " + course.toString()
        + ", professor = " + professor.toString() + "}";
    }
}
