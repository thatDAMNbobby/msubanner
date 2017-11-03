package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Entity;
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

    // todo: Add field for department

    /**
     * Title of the course.
     */
    private String myTitle;

    /**
     * Description of the course.
     */
    private String myDescription;

    /**
     * Credits for this course.
     */
    private int myCredits;

    /**
     * Learning objectives for this course.
     */
    private String myLearningObjectives;

    /**
     * Pre-requisites for this course.
     */
    private ClassLevel myPrereqs;

    /**
     * Department this course belongs to.
     */
    private Department myDepartment;

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
        this.myCredits = 0;
        this.myLearningObjectives = "No objective available";
        this.myPrereqs = ClassLevel.FRESHMAN;
        this.myDepartment = new Department("Blank department");
    }

    /**
     * Course constructor.
     *
     * @param title the course title
     * @param description the course description
     * @param credits the number of credits
     * @param learningObjectives the learning objectives
     * @param prereqs the prerequisites
     * @throws IllegalArgumentException if a parameter is invalid
     */
    public Course(final String title, final String description,
            final int credits, final String learningObjectives,
            final ClassLevel prereqs, final Department department)
            throws IllegalArgumentException {

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

        if (learningObjectives == null || learningObjectives.isEmpty()) {
            myLearningObjectives = "No learning objective available";
        } else {
            myLearningObjectives = learningObjectives;
        }

        if (credits < 0) {
            throw new IllegalArgumentException("Credits must be non-negative");
        }
        myCredits = credits;

        if (prereqs != null) {
            // throw new IllegalArgumentException("Prerequisite cannot be
            // null");
            myPrereqs = prereqs;
        } else {
            myPrereqs = ClassLevel.FRESHMAN;
        }

        if (department != null) {
            myDepartment = department;
        } else {
            throw new IllegalArgumentException("Department cannot be null");
        }
    }

    /**
     * Sets the id of the course.
     *
     * @param id New id for the course
     */
    public void setId(final String id) {
        this.id = id;
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
     *
     * @return Title of the course
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * Sets the decription of the course.
     *
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
     *
     * @return Description of the course
     */
    public String getDescription() {
        return myDescription;
    }

    /**
     * Sets the number of credits.
     *
     * @param credits the number of credits
     * @throws IllegalArgumentException if a negative number is used
     */
    public void setCredits(final int credits) throws IllegalArgumentException {
        if (credits < 0) {
            throw new IllegalArgumentException("Credits cannot be negative!");
        }
        myCredits = credits;
    }

    /**
     * Sets the learning objectives.
     *
     * @param learningObjectives the learning objectives
     */
    public void setLearningObjectives(final String learningObjectives) {
        if (learningObjectives.equals("") || learningObjectives.equals(" ")) {
            myLearningObjectives = "Default learning objectives.";
        } else {
            myLearningObjectives = learningObjectives;
        }
    }

    /**
     * Sets the prerequisites.
     *
     * @param prereqs the class level prereq
     */
    public void setPrereqs(final ClassLevel prereqs) {
        myPrereqs = prereqs;
    }

    /**
     * Gets the class level prereq.
     *
     * @return the prereq class level
     */
    public ClassLevel getPrereqs() {
        return myPrereqs;
    }

    /**
     * Gets the learning objectives.
     *
     * @return the learning objectives
     */
    public String getLearningObjectives() {
        return myLearningObjectives;
    }

    /**
     * Gets the number of credits.
     *
     * @return the number of credits
     */
    public int getCredits() {
        return myCredits;
    }

    /**
     * Gets the department.
     *
     * @return The department this course belongs to
     */
    public Department getDepartment() {
        return myDepartment;
    }

    /**
     * Sets the department.
     *
     * @param department Department this course belongs to
     * @throws IllegalArgumentException if department is null
     */
    public void setDepartment(Department department) throws IllegalArgumentException {
        if (department != null) {
            this.myDepartment = myDepartment;
        } else {
            throw new IllegalArgumentException("Department cannot be null");
        }
    }

    /**
     * toString method for Course.
     */
    @Override
    public String toString() {
        return "Course{" + "Id=" + id + ", Title= " + myTitle
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
    
}
