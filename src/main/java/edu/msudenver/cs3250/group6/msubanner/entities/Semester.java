package edu.msudenver.cs3250.group6.msubanner.entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


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
     * LocalDate object containing the start date of the Semester
     *   https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
     */
    private LocalDate semesterStartDate;

    /**
     * Public Constructor for a Semester
     * sets default values to the current LocalDate
     */
    public Semester() {

        this.semesterStartDate = LocalDate.now();
        this.semesterYear = this.semesterStartDate.getYear();
        this.autoSetSeason();
    }

    private void autoSetSeason() {
        if(
                this.semesterStartDate.getMonth().toString().equals("JANUARY") ||
                this.semesterStartDate.getMonth().toString().equals("FEBRUARY") ||
                this.semesterStartDate.getMonth().toString().equals("MARCH")) {

                    this.setSeason("Spring");
        }
        else if (
                this.semesterStartDate.getMonth().toString().equals("APRIL") ||
                this.semesterStartDate.getMonth().toString().equals("MAY")   ||
                this.semesterStartDate.getMonth().toString().equals("JUNE")  ||
                this.semesterStartDate.getMonth().toString().equals("JULY")
                ) {
                    this.setSeason("Summer");
        }
        else {

                    this.setSeason("Fall");
        }

    }

    /**
     * @return DateFormat obj of the Semester Start Date obj
     */
    public LocalDate getSemesterStartDate() {
        return this.semesterStartDate;
    }

    /**
     * Sets the semesterStartDate as a LocalDate object
     *
     * @param year the year the semester is in
     * @param month the month the semester starts
     * @param date the start day of the semester
     */
    public void setSemesterStartDate(int year, int month, int date) {
        LocalDate localDate = LocalDate.of(year, month, date);
        this.semesterStartDate = localDate;
        this.semesterYear = localDate.getYear();
        this.autoSetSeason();
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
         * @param seasonName the first letter uppercase name of the season
         */
        Season(final String seasonName) {
            this.seasonName = seasonName;
        }
    }

    /**
     * Sets the id of a Semester instance.
     *
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
     * otherwise sets with "Season Not Set"
     *
     * @param season
     */
    public void setSeason(String season) {
        if (season.equals(Season.FALL.seasonName) ||
                season.equals(Season.SPRING.seasonName) ||
                season.equals(Season.SUMMER.seasonName)) {
            this.season = season;
        } else {
            System.out.println("warning: Season must be entered as 'Fall', 'Spring' or 'Summer'");
            this.season = "Season Not Set";
        }
    }

    /**
     * @return String representing the season the Semester is in
     */
    public String getSeason() {
        return season;
    }

    /**
     * @return int representing the year the semester falls in
     */
    public int getSemesterYear() {
        return semesterYear;
    }


    /**
     * Sets a new year on the Semester
     *
     * @param semesterYear the year to be updated in the Semester
     */
    public void setSemesterYear(int semesterYear) {

        LocalDate localDate = LocalDate.of(semesterYear,
                this.semesterStartDate.getMonth(),
                this.semesterStartDate.getDayOfMonth()
        );

        this.semesterStartDate = localDate;

    }


    // TODO: check to see if there is a semester conflict, used by other classes to prevent duplication
    //       when creating a new Semester
    public boolean semesterAlreadyExists(Semester semesterToCheck) {
        // Check year and season conflict
        if(semesterToCheck.getSemesterYear() == this.semesterStartDate.getYear() &&
                semesterToCheck.season.equals(this.season)) {
            return true;
        }
        return false;
    }

    // TODO: set default season based on constructor

    // TODO: make sure javadoc is in line with other doc in here
}
