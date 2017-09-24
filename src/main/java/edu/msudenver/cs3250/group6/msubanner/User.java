package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent User class.
 */
@Entity
@Table(name = "users")
public class User {

    /** User's id number. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;

    /** User's first name. */
    @Column
    private String myFirstName;

    /** User's last name. */
    @Column
    private String myLastName;

    /** Default constructor for user class. */
    public User() {
        try {
            this.myFirstName = "First_Name";
            this.myLastName = "Last_Name";
        } catch (Exception e) {
            System.out.println("Something went wrong...");
        }
    }

    /**
     * Constructor.
     * @param firstName the user's firat name
     * @param lastName the user's last name
     */
    public User(final String firstName, final String lastName) {
        super();
        // this.id = id;
        if (firstName != "") {
            myFirstName = firstName;
        } else {
            myFirstName = "First_Name";
        }

        if (lastName != "") {
            myLastName = lastName;
        } else {
            myLastName = "Last_Name";
        }
    }

    /**
     * Returns the first name of the User.
     * @return first name
     * @throws Exception if the first name field is blank
     */
    public String getFirstName() throws Exception {
        if (myFirstName != "") {
            return myFirstName;
        } else {
            throw new Exception("First name cannot be blank!");
        }
    }

    /**
     * Returns the last name of the User.
     * @return last name
     * @throws Exception if the last name field is blank
     */
    public String getLastName() throws Exception {
        if (myLastName != "") {
            return myLastName;
        } else {
            throw new Exception("Last name cannot be blank!");
        }
    }

    /**
     * Returns the id number of the User.
     * @return id
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the user's id.
     * @param id the id number
     * @throws Exception if the id number is less than 1
     */
    public void setId(final long id) throws Exception {
        if (id > 0) {
            myId = id;
        } else {
            throw new Exception("Invalid Id. Id cannot be less than 1.");
        }
    }

    /**
     * Sets the user's first name.
     * @param firstName the first name
     */
    public void setFirstName(final String firstName) {
        if (firstName != "") {
            myFirstName = firstName;
        } else {
            myFirstName = "First_Name";
        }
    }

    /**
     * Sets the user's last name.
     * @param lastName the last name
     */
    public void setLastName(final String lastName) {

        if (lastName != "") {
            myLastName = lastName;
        } else {
            myLastName = "Last_Name";
        }
    }
}
