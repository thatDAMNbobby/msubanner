package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Student class.
 */
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private String id;

    /**
     * Default constructor.
     */
    public Student(){}

    /**
     * Constructor.
     * @param firstName Student's first name
     * @param lastName Student's last name
     */
    public Student(final String firstName, final String lastName) {
        super(firstName, lastName);
    }

    /**
     * Sets the students id number.
     * @param id the new id number
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets the students first name.
     * @param firstName the new first name
     * @throws IllegalArgumentException
     */
    @Override
    public void setFirstName(String firstName) throws IllegalArgumentException {
        super.setFirstName(firstName);
    }

    /**
     * Sets the students last name.
     * @param lastName the new last name
     * @throws IllegalArgumentException
     */
    @Override
    public void setLastName(String lastName) throws IllegalArgumentException {
        super.setLastName(lastName);
    }

    /**
     * Gets the students id number.
     * @return the students id number
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Gets the students first name.
     * @return then students first name
     */
    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    /**
     * Gets the students last name.
     * @return the students last name
     */
    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
