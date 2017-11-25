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
public class Professor extends User {

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
    public Professor() {}

    /**
     * Constructor
     * @param firstname professors first name
     * @param lastname professors last name
     */
    public Professor(final String firstname, final String lastname) {
        super(firstname,lastname);
    }

    /**
     * Sets the professor's id number.
     * @param id the new id number
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the professor's id number.
     * @return the professor's id number
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     *
     * @return returns sections that professor belongs to
     */
   /* public Section getSections(){
        return sections;
    }
*/
    /**
     *
     * @return returns professors first name
     */
    public String getFirstName() {
        return super.getFirstName();
    }

    /**
     *
     * @param firstName sets professors first name to firstName
     */
    public void setFirstName(final String firstName) throws IllegalArgumentException {
        super.setFirstName(firstName);
    }

    /**
     *
     * @return returns professors last name
     */
    public String getLastName() {
        return super.getLastName();
    }

    /**
     *
     * @param lastName sets professors last name to lastName
     */
    public void setLastName(final String lastName) throws IllegalArgumentException {
        super.setLastName(lastName);
    }

    /**
     * Get hashcode for User
     *
     * @return hashCode for super (User) class
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Compares User class of Professor
     *
     * @param other User object
     * @return boolean true if two professors are equal
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    /**
     * Get String of Professor data
     *
     * @return String of Professor data
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
