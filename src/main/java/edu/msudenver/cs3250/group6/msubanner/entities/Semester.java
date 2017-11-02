package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Semester class.
 */
public class Semester {

    /**
     * Semester id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


    /**
     * String representing the Semester season
     */
    private String season;

    /**
     * Valid enum to put in season field
     */
    public enum Season {
        FALL("Fall"),
        SPRING("Spring"),
        SUMMER("Summer");

        private String seasonName;

        /**
         * Constructor for Season
         *
         * @param seasonName the not all uppercase name of the season
         */
        Season(final String seasonName) {
            this.seasonName = seasonName;
        }
    }

    /**
     *
     * @return String representing the season the Semester is in
     */
    public String getSeason() {
        return season;
    }

    /**
     * Sets the season with a valid string of the season name,
     *   otherwise sets with "Season Not Set"
     *
     * @param season
     */
    public void setSeason(String season) {
        if(     season.equals(Season.FALL.seasonName) ||
                season.equals(Season.SPRING.seasonName) ||
                season.equals(Season.SUMMER.seasonName)) {
            this.season = season;
        }
        else {
            System.out.println("warning: Season must be 'Fall', 'Spring' or 'Summer'");
            this.season = "Season Not Set";
        }
    }


    /**
     * Sets the id of a Semester instance.
     * @param id New id for the Semester
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the id number of the Semester instance.
     *
     * @return id number of the Semester
     */
    public String getId() {
        return id;
    }
}
