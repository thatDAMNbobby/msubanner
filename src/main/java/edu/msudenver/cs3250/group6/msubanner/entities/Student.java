package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Student class.
 */
public final class Student extends User {

    /** The student id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private String id;

    /**
     * Default constructor.
     */
    public Student() { }

    /**
     * Constructor.
     * @param firstName Student's first name
     * @param lastName Student's last name
     */
    public Student(final String firstName, final String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return other instanceof Student && super.equals(other);
    }
}
