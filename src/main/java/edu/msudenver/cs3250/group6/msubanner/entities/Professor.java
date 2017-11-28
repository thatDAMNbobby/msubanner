package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The professor class.
 */

public final class Professor extends User {

    private String firstName = super.getFirstName();
    private String lastName = super.getFirstName();

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
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setLastName(String lastName) throws IllegalArgumentException {
        super.setLastName(lastName);
    }

    @Override
    public void setFirstName(String firstName) throws IllegalArgumentException {
        super.setFirstName(firstName);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }


}
