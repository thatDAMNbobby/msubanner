package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.*;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private String id;

    private Student student;

    private Section section;


    /**
     * Default contructor.
     */
    public Enrollment() {}

    public Enrollment(Student student, Section section) throws Exception {
        if (hasConfilct()) {
            throw new Exception("Conflict!");
        } else {
            this.student = student;
            this.section = section;
        }
    }

    /**
     * Checks for conflicts with other sections.
     * Currently always returns false, will be implemented
     * properly at a later time
     * @return True if there is a conflict with another enrollment, false if not.
     */
    public boolean hasConfilct() {
        return false;
    }

    /**
     * Sets the student.
     * @param student the new student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Sets the section.
     * @param section the new section
     */
    public void setSection(Section section) {
        this.section = section;
    }

    /**
     * Sets the id.
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
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

