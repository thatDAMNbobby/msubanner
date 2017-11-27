package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Days Class.
 */
public class Days {

    /** Days. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** ArrayList of Day enums. */
    private HashSet<Day> dayList = new HashSet<Day>();

    /** Valid Day to populate dayList. */
    public enum Day {
        /** Sunday. */
        SUNDAY(1, "Sunday"),
        /** Monday. */
        MONDAY(2, "Monday"),
        /** Tuesday. */
        TUESDAY(3, "Tuesday"),
        /** Wednesday. */
        WEDNESDAY(4, "Wednesday"),
        /** Thursday. */
        THURSDAY(5, "Thursday"),
        /** Friday. */
        FRIDAY(6, "Friday"),
        /** Saturday. */
        SATURDAY(7, "Saturday");

        @Override
        public String toString() {
            switch (this) {
                case SUNDAY: return "Sunday";
                case MONDAY: return "Monday";
                case TUESDAY: return "Tuesday";
                case WEDNESDAY: return "Wednesday";
                case THURSDAY: return "Thursday";
                case FRIDAY: return "Friday";
                case SATURDAY: return "Saturday";
                default: throw new IllegalArgumentException();
            }
        }

        /** The day's number in the week (1-7). */
        private int myDayNum;
        /** The day's name. */
        private String myDayName;

        /**
         * Constructor for Day.
         *
         * @param dayName the name of the day
         * @param dayNum the number value of the day
         */
        Day(final int dayNum, final String dayName) {
            myDayNum = dayNum;
            myDayName = dayName;
        }

        /**
         * Gets the list of days in a string array of day names.
         *
         * @param days the string array of day names
         * @return the list of days
         */
        public static ArrayList<Day> getList(final String[] days) {
            ArrayList<Day> out = new ArrayList<Day>();
            for (String day : days) {
                for (Day name : Day.values()) {
                    if (day.equals(name.toString()) && !out.contains(name)) {
                        out.add(name);
                    }
                }
            }
            return out;
        }

    }

    /**
     * Sets the id of an Days instance.
     *
     * @param idNum the day id
     */
    public void setId(final String idNum) {
        this.id = idNum;
    }

    /**
     * Returns the id of the Days.
     *
     * @return String id number of the Days
     */
    public String getId() {
        return this.id;
    }

    /**
     * Adds an association of number to day to the dayList HashMap.
     *
     * @param dayToAdd the day to add to the day list
     */
    public void addToDayList(final Day dayToAdd) {
        switch (dayToAdd) {
        case SUNDAY:
        case MONDAY:
        case TUESDAY:
        case WEDNESDAY:
        case THURSDAY:
        case FRIDAY:
        case SATURDAY:
            dayList.add(dayToAdd);
            break;
        default:
            System.out.println("Console Warning: Invalid input '" + dayToAdd
                    + "', Days.addToDayList() expected a capitalized day name"
                    + ", ie. Monday, Tuesday, etc");
        }
    }

    /**
     * Removes an association of number to day to the dayList HashMap.
     *
     * @param dayToRemove the day to remove from the list
     */
    public void removeDayFromList(final Day dayToRemove) {
        switch (dayToRemove) {
        case SUNDAY:
        case MONDAY:
        case TUESDAY:
        case WEDNESDAY:
        case THURSDAY:
        case FRIDAY:
        case SATURDAY:
            dayList.remove(dayToRemove);
            break;
        default:
            System.out.println("Console Warning: Invalid input '" + dayToRemove
                    + "', Days.removeDayFromList() expected a capitalized day"
                    + "name, ie. Monday, Tuesday, etc");
        }
    }

    /**
     * Returns a HashMap of Day values.
     *
     * @return HashMap of Day values
     */
    public HashSet<Day> getDayList() {
        return dayList;
    }

    /**
     * Checks to see if there is conflict between two sets of days.
     *
     * @param setToCompare the days list to be compared against the calling days
     *        list
     * @return true if there is a conflict between days
     */
    public boolean hasConflict(final HashSet<Day> setToCompare) {
        for (Day day : dayList) {
            if (setToCompare.contains(day)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string of the values in the day list.
     *
     * @return a String of Days
     */
    @Override
    public String toString() {
        List<Day> sortedList = new ArrayList<Day>(dayList);
        Collections.sort(sortedList);
        String output = sortedList.toString();
        String replaced = output.replace("[", "").replace("]", "");
        return replaced;
        //return output.substring(1,output.length() - 1);
    }
}
