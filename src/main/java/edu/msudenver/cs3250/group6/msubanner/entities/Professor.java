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
     * @param firstName professors first name
     * @param lastName professors last name
     */
    public Professor(final String firstName, final String lastName) {
        super(firstName, lastName);
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
