package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent Course class.
 */
@Entity
@Table(name = "courses")
public class Course {

    /**
     * Course id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;

    // todo: Add field for department

    /**
     * Title of the course.
     */
    @Column
    private String myTitle;

    /**
     * Description of the course.
     */
    private String myDescription;

    /** Constant multiplier for hash method. */
    private static final int HASH_MULTIPLIER = 31;

    /** Constant base for hash method. */
    private static final int HASH_BASE = 17;

    /**
     * Default constructor, initializes fields with default values. Directions
     * for use: Do NOT
     */
    public Course() {
        this.myTitle = "Empty title";
        this.myDescription = "No description available";
    }

    /**
     * Constructor.
     * @param title Course Title
     * @param description Course description
     */
    public Course(final String title, final String description) {
        if (title == null || title.isEmpty()) {
            myTitle = "Empty title";
        } else {
            myTitle = title;
        }
        if (description == null || description.isEmpty()) {
            myDescription = "No description available";
        } else {
            myDescription = description;
        }
    }

    /**
     * Sets the id of the course.
     * @param id New id for the course
     */
    public void setId(final long id) {
        if (id > 0) {
            myId = id;
        }
    }

    /**
     * Returns the id number of the course.
     * @return id number of the course
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the title of the course.
     * @param title New title of the course
     * @throws IllegalArgumentException if new title is blank
     */
    public void setTitle(final String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.myTitle = title;
    }

    /**
     * Returns the title of the course.
     * @return Title of the course
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * Sets the decription of the course.
     * @param description New description of the course
     */
    public void setDescription(final String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be blank!");
        }
        this.myDescription = description;
    }

    /**
     * Returns the description of the course.
     * @return Description of the course
     */
    public String getDescription() {
        return myDescription;
    }

    /**
     * toString method for Course.
     */
    @Override
    public String toString() {
        return "Course{" + "Id=" + myId + ", Title= " + myTitle
                + ", Description= " + myDescription + "}";
    }

    /**
     * equals method for Course.
     */
    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof Course)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        Course course = (Course) o;
        return this.getId() == course.getId()
                && this.getDescription().equals(course.getDescription())
                && this.getTitle().equals(course.getTitle());
    }

    /**
     * hashCode method for Course.
     */
    @Override
    public int hashCode() {
        int result = HASH_BASE;
        result = (int) (HASH_MULTIPLIER * result + myId);
        result = HASH_MULTIPLIER * result + myTitle.hashCode();
        result = HASH_MULTIPLIER * result + myDescription.hashCode();
        return result;
    }
}
