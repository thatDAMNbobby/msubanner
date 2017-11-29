package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;

/**
 * Persistent Course class.
 */
public class Course {

    /**
     * Course id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Title of the course.
     */
    private String title;

    /**
     * Description of the course.
     */
    private String description;

    /**
     * Credits for this course.
     */
    private int credits;

    /**
     * Learning objectives for this course.
     */
    private String learningObjectives;

    /**
     * Pre-requisites for this course.
     */
    private ClassLevel prereqs;

    /**
     * Department this course belongs to.
     */
    private Department department;

    /**
     * Default constructor, initializes fields with default values. Directions
     * for use: Do NOT
     */
    public Course() {
        this.title = "Empty title";
        this.description = "No description available";
        this.credits = 0;
        this.learningObjectives = "No objective available";
        this.prereqs = ClassLevel.FRESHMAN;
        this.department = new Department("Blank department");
    }

    /**
     * Course constructor.
     *
     * @param newTitle the course title
     * @param newDescription the course description
     * @param newCredits the number of credits
     * @param newObjectives the learning objectives
     * @param newPrereqs the prerequisites
     * @param newDepartment the department
     * @throws IllegalArgumentException if a parameter is invalid
     */
    public Course(final String newTitle, final String newDescription,
            final int newCredits, final String newObjectives,
            final ClassLevel newPrereqs, final Department newDepartment)
                    throws IllegalArgumentException {

        if (newTitle == null || newTitle.isEmpty()) {
            title = "Empty title";
        } else {
            title = newTitle;
        }
        if (newDescription == null || newDescription.isEmpty()) {
            description = "No description available";
        } else {
            description = newDescription;
        }

        if (newObjectives == null || newObjectives.isEmpty()) {
            learningObjectives = "No learning objective available";
        } else {
            learningObjectives = newObjectives;
        }

        if (newCredits < 0) {
            throw new IllegalArgumentException("Credits must be non-negative");
        }
        credits = newCredits;

        if (newPrereqs != null) {
            // throw new IllegalArgumentException("Prerequisite cannot be
            // null");
            prereqs = newPrereqs;
        } else {
            prereqs = ClassLevel.FRESHMAN;
        }

        if (newDepartment != null) {
            department = newDepartment;
        } else {
            throw new IllegalArgumentException("Department cannot be null");
        }
    }

    /**
     * Sets the id of the course.
     *
     * @param newId New id for the course
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Returns the id number of the course.
     *
     * @return id number of the course
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the title of the course.
     *
     * @param newTitle New title of the course
     * @throws IllegalArgumentException if new title is blank
     */
    public void setTitle(final String newTitle)
            throws IllegalArgumentException {
        if (newTitle == null || newTitle.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = newTitle;
    }

    /**
     * Returns the title of the course.
     *
     * @return Title of the course
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the decription of the course.
     *
     * @param newDescription New description of the course
     */
    public void setDescription(final String newDescription) {
        if (newDescription == null || newDescription.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be blank!");
        }
        this.description = newDescription;
    }

    /**
     * Returns the description of the course.
     *
     * @return Description of the course
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the number of credits.
     *
     * @param newCredits the number of credits
     * @throws IllegalArgumentException if a negative number is used
     */
    public void setCredits(final int newCredits)
            throws IllegalArgumentException {
        if (newCredits < 0) {
            throw new IllegalArgumentException("Credits cannot be negative!");
        }
        credits = newCredits;
    }

    /**
     * Sets the learning objectives.
     *
     * @param newObjectives the learning objectives
     */
    public void setLearningObjectives(final String newObjectives) {
        if (newObjectives == null || newObjectives.isEmpty()) {
            learningObjectives = "Default learning objectives.";
        } else {
            learningObjectives = newObjectives;
        }
    }

    /**
     * Sets the prerequisites.
     *
     * @param newPrereqs the class level prereq
     */
    public void setPrereqs(final ClassLevel newPrereqs) {
        prereqs = newPrereqs;
    }

    /**
     * Gets the class level prereq.
     *
     * @return the prereq class level
     */
    public ClassLevel getPrereqs() {
        return prereqs;
    }

    /**
     * Gets the learning objectives.
     *
     * @return the learning objectives
     */
    public String getLearningObjectives() {
        return learningObjectives;
    }

    /**
     * Gets the number of credits.
     *
     * @return the number of credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Gets the department.
     *
     * @return The department this course belongs to
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param newDepartment Department this course belongs to
     * @throws IllegalArgumentException if department is null
     */
    public void setDepartment(final Department newDepartment)
            throws IllegalArgumentException {
        if (newDepartment != null) {
            this.department = newDepartment;
        } else {
            throw new IllegalArgumentException("Department cannot be null");
        }
    }

    /**
     * toString method for Course.
     */
    @Override
    public String toString() {
        return "Course{" + "Id=" + id + ", Title= " + title + ", Description= "
                + description + "}";
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
        return Objects.equals(id, course.id)
                && Objects.equals(title, course.title)
                && Objects.equals(description, course.description);
    }

    /**
     * hashCode method for Course.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
