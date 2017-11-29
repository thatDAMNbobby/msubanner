package edu.msudenver.cs3250.group6.msubanner.entities;

/**
 * The professor class.
 */
public final class Professor extends User {
    /**
     * Default constructor, creates blank professor.
     */
    public Professor() {
    }

    /**
     * Constructor.
     *
     * @param firstname professors first name
     * @param lastname professors last name
     */
    public Professor(final String firstname, final String lastname) {
        super(firstname, lastname);
    }

    @Override
    public boolean equals(final Object other) {
        return other instanceof Professor && super.equals(other);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
