package edu.msudenver.cs3250.group6.msubanner.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private User professor;

    /** Number used to compute hash value. */
    private static final int HASH_SHIFT = 32;

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
     */
    public Section(final Course course, final User professor) {
        if (course != null) {
            this.course = course;
        }
        if (professor != null) {
            this.professor = professor;
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
            this.course = course;
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
        return course;
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
        this.course = course;
    }

    /**
     * Returns the professor of this section.
     *
     * @return the professor of this section
     */
    public User getProfessor() { return professor; }

    /**
     * Sets the professor of this section.
     *
     * @param professor new professor for this section
     * @throws IllegalArgumentException if the professor is null
     */
    public void setProfessor(final User professor)
            throws IllegalArgumentException {
        if (professor == null) {
            throw new IllegalArgumentException("Professor cannot be null!");
        }
        this.professor = professor;
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
        return this.getId() == otherSection.getId()
                && this.getCourse().equals(otherSection.getCourse())
                && this.getProfessor().equals(otherSection.getProfessor());
    }

    /**
     * Returns the Section as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", Course=" + course.toString()
                + ", professor:" + professor.toString() + '}';
    }
}
