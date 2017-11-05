package edu.msudenver.cs3250.group6.msubanner.entities;

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
     * LocalDate object containing the start date of the Semester
     * https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
     */
    private LocalDate semesterStartDate = LocalDate.now();

    /**
     * LocalDate object containing the end date of the Semester
     *   auto initializes to roughly 3 months after semesterStartDate
     *   with some constraints and day default to 20
     */
    private LocalDate semesterEndDate = LocalDate.of(
            semesterStartDate.getMonthValue() > 9 ? semesterStartDate.getYear() + 1 : semesterStartDate.getYear(),
            semesterStartDate.getMonthValue() <= 9 ? semesterStartDate.getMonthValue() + 3 : 1,
            25
    );

    /**
     * String representing the Semester season
     */
    private String season = autoSetSeason();

    /**
     * Initialize or set season field automatically based on semesterStartDate
     *
     * @return String of the season, for purpose of initializing this.season
     */
    private String autoSetSeason() {
        if (
                this.semesterStartDate.getMonth().toString().equals("JANUARY") ||
                        this.semesterStartDate.getMonth().toString().equals("FEBRUARY") ||
                        this.semesterStartDate.getMonth().toString().equals("MARCH")) {

            this.setSeason("Spring");
            return "Spring";
        } else if (
                this.semesterStartDate.getMonth().toString().equals("APRIL") ||
                        this.semesterStartDate.getMonth().toString().equals("MAY") ||
                        this.semesterStartDate.getMonth().toString().equals("JUNE") ||
                        this.semesterStartDate.getMonth().toString().equals("JULY")
                ) {
            this.setSeason("Summer");
            return "Summer";
        } else {

            this.setSeason("Fall");
        }
        return "Fall";
    }

    /**
     * @return LocalDate obj of the Semester Start Date obj
     */
    public LocalDate getSemesterStartDate() {
        return this.semesterStartDate;
    }

    /**
     * Sets the semesterStartDate as a LocalDate obj
     *
     * @param year  the year the semester is in
     * @param month the month the semester starts
     * @param date  the start day of the semester
     */
    public void setSemesterStartDate(int year, int month, int date) {
        LocalDate localDate = LocalDate.of(year, month, date);
        this.semesterStartDate = localDate;
        this.autoSetSeason();

        if(semesterStartDate.getYear() > semesterEndDate.getYear() ||
                (semesterStartDate.getYear() == semesterEndDate.getYear() &&
                 semesterStartDate.getMonthValue() > semesterEndDate.getMonthValue())
                ) {
            setSemesterEndDate();
        }
    }

    /**
     * @return LocalDate obj of the Semester End Date obj
     */
    public LocalDate getSemesterEndDate() {
        return this.semesterEndDate;
    }

    /**
     * Sets the semesterEndDate as a LocalDate obj if the semesterStartDate
     *   is in an earlier month than the semesterEndDate, else autosets
     *   a value in the future.
     *
     * @param endYear  the year the semester ends
     * @param endMonth the month the semester ends
     * @param endDate  the end day of the semester
     */
    public void setSemesterEndDate(int endYear, int endMonth, int endDate) {
        if(semesterStartDate.getYear() < endYear ||
               (semesterStartDate.getYear() <= endYear &&
                semesterStartDate.getMonthValue() < endMonth)
           ) {
            LocalDate localDate = LocalDate.of(endYear, endMonth, endDate);
            this.semesterEndDate = localDate;
        }
        else{
            LocalDate localDate = LocalDate.of(
                    semesterStartDate.getMonthValue() > 9 ? semesterStartDate.getYear() + 1 : semesterStartDate.getYear(),
                    semesterStartDate.getMonthValue() <= 9 ? semesterStartDate.getMonthValue() + 3 : 1,
                    25
            );
            System.out.println("warning: semesterEndDate automatically set, semesterEndDate must occur after semesterStartDate");

        }
    }

    /**
     * Sets the semesterEndDate automatically based off of the
     *   semesterStartDate
     */
    private void setSemesterEndDate() {
            LocalDate localDate = LocalDate.of(
                    semesterStartDate.getMonthValue() > 9 ? semesterStartDate.getYear() + 1 : semesterStartDate.getYear(),
                    semesterStartDate.getMonthValue() <= 9 ? semesterStartDate.getMonthValue() + 3 : 1,
                    25
            );
            this.semesterEndDate = localDate;
    }

    /**
     * Valid enum to put in season field
     */
    public enum Season {
        FALL("Fall"),
        SPRING("Spring"),
        SUMMER("Summer");

        /**
         * String value of enum association for season
         */
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
        return this.id;
    }

    /**
     * Sets the season with a valid string of the season name,
     * otherwise permissively runs autoSetSeason()
     *
     * @param season the season to update to
     */
    public void setSeason(String season) {
        if (season.equals(Season.FALL.seasonName) ||
                season.equals(Season.SPRING.seasonName) ||
                season.equals(Season.SUMMER.seasonName)) {
            this.season = season;
        } else {
            System.out.println("warning: Season must be entered as 'Fall', 'Spring' or 'Summer'");
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

    /**
     * hasConflict() checks only if there is a conflict of the year and season and
     * does not check for conflict with the specific LocalDate object's month or day.
     * - can be used to verify that there is only one semester with a given year and season
     * - can be used to check if a section has a scheduling conflict
     *
     * @param semesterToCheck the semester to check against the current instance
     * @return boolean true if conflict exists, false if conflict does not exist
     */
    public boolean hasConflict(Semester semesterToCheck) {
        if (semesterToCheck.getSemesterYear() == this.semesterStartDate.getYear() &&
                semesterToCheck.season.equals(this.season)) {
            return true;
        }
        return false;
    }
}
