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
     * Semester id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;


    /**
     * Default constructor, creates blank professor.
     */
    public Professor() {}

    /**
     *
     * @param firstname professors first name
     * @param lastname professors last name
     */
    public Professor(final String firstname, final String lastname) {
        super(firstname,lastname);
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
    public void setFirstName(final String firstName) {
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
    public void setLastName(final String lastName) {
        super.setLastName(lastName);
    }

}
