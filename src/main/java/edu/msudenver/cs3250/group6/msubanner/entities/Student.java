package edu.msudenver.cs3250.group6.msubanner.entities;

/**
 * Student class.
 */
public final class Student extends User {

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Constructor.
     *
     * @param firstName Student's first name
     * @param lastName Student's last name
     */
    public Student(final String firstName, final String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(final Object other) {
        return other instanceof Student && super.equals(other);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
