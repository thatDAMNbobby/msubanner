package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent User class.
 */
public class User {

    /** User's id number. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** The user's first name. */
    private String myFirstName;

    /** The user's last name. */
    private String myLastName;

    /** Default constructor for user class. */
    public User() {
        this.myFirstName = "First_Name";
        this.myLastName = "Last_Name";
    }

    /**
     * Constructor.
     *
     * @param firstName the user's firat name
     * @param lastName the user's last name
     */
    public User(final String firstName, final String lastName) {
        if (firstName == null || firstName.equals("")) {
            this.myFirstName = "First_Name";
        } else {
            this.myFirstName = firstName;
        }
        if (lastName == null || lastName.equals("")) {
            this.myLastName = "Last_Name";
        } else {
            this.myLastName = lastName;
        }
    }

    /**
     * Returns the first name of the User.
     *
     * @return first name
     * @throws Exception if the first name field is blank
     */
    public String getFirstName() {
        return myFirstName;
    }

    /**
     * Returns the last name of the User.
     *
     * @return last name
     * @throws Exception if the last name field is blank
     */
    public String getLastName() {
        return myLastName;
    }

    /**
     * Returns the id number of the User.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the user's id.
     *
     * @param id the id number
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName the first name
     * @throws IllegalArgumentException if the first name value is null or empty
     */
    public void setFirstName(final String firstName)
            throws IllegalArgumentException {
        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException(
                    "First name must not be empty or null.");
        }
        this.myFirstName = firstName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName the last name
     * @throws IllegalArgumentException if the last name value is null or empty
     */
    public void setLastName(final String lastName)
            throws IllegalArgumentException {
        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException(
                    "Last name must not be empty or null.");
        }
        this.myLastName = lastName;
    }

    /**
     * Required explanation on how to implement this for classes that extend
     * User.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof User)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        final User otherUser = (User) other;
        return this.getId() == otherUser.getId()
                && this.getFirstName().equals(otherUser.getFirstName())
                && this.getLastName().equals(otherUser.getLastName());
    }

    /**
     * Required explanation on how to implement this for classes that extend
     * User.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + myFirstName + " "
                + myLastName + " " + id;
    }

}
