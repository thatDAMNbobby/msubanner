package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The professor class.
 */
@Entity
public final class Professor extends User {

    /**
     * Professor id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private String id;

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


}
