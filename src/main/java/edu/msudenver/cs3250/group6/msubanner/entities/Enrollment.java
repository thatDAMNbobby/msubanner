package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;

/** The enrollment class for students/sections. */
public class Enrollment {
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** The student. */
    @DBRef
    private Student student;

    /** The section. */
    @DBRef
    private Section section;

    /**
     * Default constructor.
     */
    public Enrollment() {
    }

    /**
     * General constructor for an enrollment.
     *
     * @param newStudent the student enrolling
     * @param newSection the section for enrollment
     * @throws Exception if there is a conflict in the student's schedule
     */
    public Enrollment(final Student newStudent, final Section newSection)
            throws Exception {
        if (hasConflict()) {
            throw new Exception("Conflict!");
        } else {
            this.student = newStudent;
            this.section = newSection;
        }
    }

    /**
     * Checks for conflicts with other sections.
     *
     * @return if there is a conflict with another enrollment
     */
    public boolean hasConflict() {
        //TODO: complete implementation.
        return false;
    }

    /**
     * Sets the student.
     *
     * @param newStudent the new student
     */
    public void setStudent(final Student newStudent) {
        this.student = newStudent;
    }

    /**
     * Sets the section.
     * @param newSection the new section
     */
    public void setSection(final Section newSection) {
        this.section = newSection;
    }

    /**
     * Sets the id.
     * @param newId the new id
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets the student.
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets the section.
     * @return the section
     */
    public Section getSection() {
        return section;
    }

    /**
     * Gets the id.
     * @return the id
     */
    public String getId() {
        return id;
    }
}
