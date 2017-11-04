package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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
     * int representing the year of the Semester
     */
    private int semesterYear;

    /**
     * java.util.Date object containing the start date of the Semester
     */
    private Date semesterStartDate;

    /**
     *
     * @return DateFormat obj of the Semester Start Date obj
     */
    public String getSemesterStartDate() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        return dateFormat.format(semesterStartDate);
    }



    public void setSeasonStartDate(int year, int month, int date) {
        GregorianCalendar dateBuild = new GregorianCalendar(year, month-1, date);
        Date dateObj = dateBuild.getTime();
        this.semesterStartDate = dateObj;
        System.out.println("Semester Start Date set as: " + this.semesterStartDate);
    }



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
     *
     * @return String representing the season the Semester is in
     */
    public String getSeason() {
        return season;
    }

    /**
     *
     * @return int representing the year the semester falls in
     */
    public int getSemesterYear() {
        return semesterYear;
    }

    // TODO: public void setYear, CHANGE TO JAVA.UTIL.DATE OBJECT METHODS
    public void setSemesterYear(int semesterYear) {
        this.semesterYear = semesterYear;

    }


    // TODO: public void setStartDate

    // TODO: public boolean checkDuplicate and integrate into constructor


}
