package edu.msudenver.cs3250.group6.msubanner.entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Semester class.
 */
public class Semester {
    /** Number representation of August. */
    private static final int AUGUST = 8;

    /** Number representation of December / months in a year. */
    private static final int DECEMBER = 12;

    /** Number of months in a typical semester. */
    private static final int SEMESTER_LENGTH = 4;

    /**
     * Semester id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * LocalDate object containing the start date of the Semester.
     * https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
     */
    private LocalDate semesterStartDate = LocalDate.now();

    /**
     * LocalDate object containing the end date of the Semester. auto
     * initializes to roughly 3 months after semesterStartDate with some
     * constraints and day default to 20
     */
    private LocalDate semesterEndDate = generateSemesterEndDate();

    /**
     * String representing the Semester season.
     */
    private String season = autoSetSeason();

    // TODO: create default and parameterized constructors

    /**
     * Initialize or set season field automatically based on semesterStartDate.
     *
     * @return String of the season, for purpose of initializing this.season
     */
    private String autoSetSeason() {
        if (this.semesterStartDate.getMonth().toString().equals("JANUARY")
                || this.semesterStartDate.getMonth().toString()
                .equals("FEBRUARY")
                || this.semesterStartDate.getMonth().toString()
                .equals("MARCH")) {

            this.setSeason("Spring");
            return "Spring";
        } else if (this.semesterStartDate.getMonth().toString().equals("APRIL")
                || this.semesterStartDate.getMonth().toString().equals("MAY")
                || this.semesterStartDate.getMonth().toString().equals("JUNE")
                || this.semesterStartDate.getMonth().toString()
                .equals("JULY")) {
            this.setSeason("Summer");
            return "Summer";
        } else {

            this.setSeason("Fall");
        }
        return "Fall";
    }

    /**
     * Generates a rough end date for a semester 4 months later.
     *
     * @return the estimated semester end date
     */
    private LocalDate generateSemesterEndDate() {
        int endMonth;
        int endYear;
        if (semesterStartDate.getMonthValue() > AUGUST) {
            endYear = semesterStartDate.getYear() + 1;
        } else {
            endYear = semesterStartDate.getYear();
        }
        endMonth = (semesterStartDate.getMonthValue() + SEMESTER_LENGTH)
                % DECEMBER;
        if (endMonth == 0) {
            endMonth = DECEMBER;
        }
        return LocalDate.of(endYear, endMonth,
                semesterStartDate.getDayOfMonth());
    }

    /**
     * @return LocalDate obj of the Semester Start Date obj
     */
    public LocalDate getSemesterStartDate() {
        return this.semesterStartDate;
    }

    /**
     * Sets the semesterStartDate as a LocalDate obj.
     *
     * @param year the year the semester is in
     * @param month the month the semester starts
     * @param date the start day of the semester
     */
    public void setSemesterStartDate(final int year, final int month,
            final int date) {
        LocalDate localDate = LocalDate.of(year, month, date);
        this.semesterStartDate = localDate;
        this.autoSetSeason();

        if (semesterStartDate.getYear() > semesterEndDate.getYear()
                || (semesterStartDate.getYear() == semesterEndDate.getYear()
                && semesterStartDate.getMonthValue() > semesterEndDate
                .getMonthValue())) {
            LocalDate endDate = generateSemesterEndDate();
            setSemesterEndDate(endDate.getYear(), endDate.getMonthValue(),
                    endDate.getDayOfMonth());
        }
    }

    /**
     * @return LocalDate obj of the Semester End Date obj
     */
    public LocalDate getSemesterEndDate() {
        return this.semesterEndDate;
    }

    /**
     * Sets the semesterEndDate as a LocalDate obj if the semesterStartDate is
     * in an earlier month than the semesterEndDate, else autosets a value in
     * the future.
     *
     * @param endYear the year the semester ends
     * @param endMonth the month the semester ends
     * @param endDate the end day of the semester
     */
    public void setSemesterEndDate(final int endYear, final int endMonth,
            final int endDate) {
        LocalDate localDate;
        if (semesterStartDate.getYear() < endYear
                || (semesterStartDate.getYear() <= endYear
                && semesterStartDate.getMonthValue() < endMonth)) {
            localDate = LocalDate.of(endYear, endMonth, endDate);
        } else {
            localDate = generateSemesterEndDate();
            System.out.println("warning: semesterEndDate automatically set,"
                    + " semesterEndDate must occur after semesterStartDate");
        }
        this.semesterEndDate = localDate;
    }

    /**
     * Valid enum to put in season field.
     */
    public enum Season {
        /** Fall. */
        FALL("Fall"),
        /** Spring. */
        SPRING("Spring"),
        /** Summer. */
        SUMMER("Summer");

        /**
         * String value of enum association for season.
         */
        private String seasonName;

        /**
         * Constructor for Season.
         *
         * @param newSeasonName the first letter uppercase name of the season
         */
        Season(final String newSeasonName) {
            this.seasonName = newSeasonName;
        }
    }

    /**
     * Sets the id of a Semester instance.
     *
     * @param newId New id for the Semester
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Returns the id number of the Semester instance.
     *
     * @return id number of the Semester
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the season with a valid string of the season name, otherwise
     * permissively runs autoSetSeason().
     *
     * @param newSeason the season to update to
     */
    public void setSeason(final String newSeason) {
        if (newSeason.equals(Season.FALL.seasonName)
                || newSeason.equals(Season.SPRING.seasonName)
                || newSeason.equals(Season.SUMMER.seasonName)) {
            this.season = newSeason;
        } else {
            System.out.println("warning: Season must be entered as"
                    + " 'Fall', 'Spring' or 'Summer'");
            this.autoSetSeason();
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
        return this.semesterStartDate.getYear();
    }

    /**
     * Sets a new year on the Semester.
     *
     * @param semesterYear the year to be updated in the Semester
     */
    public void setSemesterYear(final int semesterYear) {
        LocalDate localDate = LocalDate.of(semesterYear,
                this.semesterStartDate.getMonth(),
                this.semesterStartDate.getDayOfMonth());
        this.semesterStartDate = localDate;
    }

    /**
     * hasConflict() checks only if there is a conflict of the year and season
     * and does not check for conflict with the specific LocalDate object's
     * month or day. - can be used to verify that there is only one semester
     * with a given year and season - can be used to check if a section has a
     * scheduling conflict
     *
     * @param semesterToCheck the semester to check against the current instance
     * @return boolean true if conflict exists, false if conflict does not exist
     */
    public boolean hasConflict(final Semester semesterToCheck) {
        if (semesterToCheck.getSemesterYear() == this.semesterStartDate
                .getYear() && semesterToCheck.season.equals(this.season)) {
            return true;
        }
        return false;
    }

    /**
     * toString for Semester.
     */
    @Override
    public String toString() {
        return season + ", " + getSemesterYear();
    }
}
