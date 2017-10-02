package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.*;

/**
 * Persistent Course class.
 */
@Entity
@Table(name = "courses")
public class Course {

    /**
     * Course id number
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //todo: Add field for department

    /**
     * Title of the course
     */
    @Column
    private String title;

    /**
     * Description of the course.
     */
    private String description;

    /**
     * Default constructor, initializes fields with default values
     * Directions for use: Do NOT
     */
    public Course() {
        this.title = "Empty title";
        this.description = "No description available";
    }

    /**
     * Constructor
     * @param title Course Title
     * @param description Course description
     */
    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Sets the id of the course.
     * @param id New id for the course
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the id number of the course.
     * @return id number of the course
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the title of the course.
     * @param title New title of the course
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the title of the course.
     * @return Title of the course
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the decription of the course.
     * @param description New description of the course
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the course.
     * @return Description of the course
     */
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;
        if (getId() != course.getId()) return false;
        if (!getTitle().equals(course.getTitle())) return false;
        return getDescription().equals(course.getDescription());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
