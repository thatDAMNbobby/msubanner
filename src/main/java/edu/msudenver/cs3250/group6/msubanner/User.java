package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent User class.
 * @author Group 6
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * User's id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;

    /**
     * Returns the first name of the User.
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Returns the last name of the User.
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the id number of the User.
     * @return id
     */
    public long getId() {
        return id;
    }
}
