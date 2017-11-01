package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Persistent Days Class
 */
public class Days {

    /**
     * Days
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * ArrayList of Day enums
     */
    private HashMap<Integer,String> dayList = new HashMap<Integer,String>();

    /**
     * Valid Day to populate dayList
     */
    public enum Day {
        SUNDAY(1, "Sunday"),
        MONDAY(2, "Monday" ),
        TUESDAY(3, "Tuesday"),
        WEDNESDAY(4, "Wednesday"),
        THURSDAY(5, "Thursday"),
        FRIDAY(6, "Friday"),
        SATURDAY(7, "Saturday");

        private int dayNum;
        private String dayName;

        /**
         * Constructor for Day
         *
         * @param dayName the name of the day
         * @param dayNum the number value of the day
         */
        Day(int dayNum, final String dayName) {
            this.dayNum = dayNum;
            this.dayName = dayName;
        }
    }

    /**
     * Sets the id of an Days instance.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the id of the Days
     *
     * @return String id number of the Days
     */
    public String getId() { return id; }

    /**
     * Adds an association of number to day to the dayList HashMap
     *
     * @param dayToAdd
     */
    public void addToDayList(String dayToAdd) {
        if(dayToAdd.equals(Day.SUNDAY.dayName)) {
            dayList.put(Day.SUNDAY.dayNum, Day.SUNDAY.dayName);
        }
        else if(dayToAdd.equals(Day.MONDAY.dayName)) {
            dayList.put(Day.MONDAY.dayNum, Day.MONDAY.dayName);
        }
        else if(dayToAdd.equals(Day.TUESDAY.dayName)) {
            dayList.put(Day.TUESDAY.dayNum, Day.TUESDAY.dayName);
        }
        else if(dayToAdd.equals(Day.WEDNESDAY.dayName)) {
            dayList.put(Day.WEDNESDAY.dayNum, Day.WEDNESDAY.dayName);
        }
        else if(dayToAdd.equals(Day.THURSDAY.dayName)) {
            dayList.put(Day.THURSDAY.dayNum, Day.THURSDAY.dayName);
        }
        else if(dayToAdd.equals(Day.FRIDAY.dayName)) {
            dayList.put(Day.FRIDAY.dayNum, Day.FRIDAY.dayName);
        }
        else if(dayToAdd.equals(Day.SATURDAY.dayName)) {
            dayList.put(Day.SATURDAY.dayNum, Day.SATURDAY.dayName);
        }
        else {
            System.out.println("Console Warning: Invalid input '"+ dayToAdd +"', Days.addToDayList() expected a capitalized day name, ie. Monday, Tuesday, etc");
        }
    }

    /**
     * Removes an association of number to day to the dayList HashMap
     *
     * @param dayToRemove
     */
    public void removeDayFromList(String dayToRemove) {
        if(dayToRemove.equals(Day.SUNDAY.dayName)) {
            dayList.remove(Day.SUNDAY.dayNum);
        }
        else if(dayToRemove.equals(Day.MONDAY.dayName)) {
            dayList.remove(Day.MONDAY.dayNum);
        }
        else if(dayToRemove.equals(Day.TUESDAY.dayName)) {
            dayList.remove(Day.TUESDAY.dayNum);
        }
        else if(dayToRemove.equals(Day.WEDNESDAY.dayName)) {
            dayList.remove(Day.WEDNESDAY.dayNum);
        }
        else if(dayToRemove.equals(Day.THURSDAY.dayName)) {
            dayList.remove(Day.THURSDAY.dayNum);
        }
        else if(dayToRemove.equals(Day.FRIDAY.dayName)) {
            dayList.remove(Day.FRIDAY.dayNum);
        }
        else if(dayToRemove.equals(Day.SATURDAY.dayName)) {
            dayList.remove(Day.SATURDAY.dayNum);
        }
        else {
            System.out.println("Console Warning: Invalid input '"+ dayToRemove +"', Days.removeDayFromList() expected a capitalized day name, ie. Monday, Tuesday, etc");
        }

    }

    /**
     * Returns a HashMap of Day values
     *
     * @return HashMap of Day values
     */
    public HashMap<Integer,String> getDayList() {
        return dayList;
    }

    /**
     * Checks to see if there is crossover between two days
     * inspired by: https://stackoverflow.com/questions/18644579/getting-the-difference-between-two-sets
     *
     * @param mapToCompare the days list to be compared against the calling days list
     * @return
     */
    public boolean hasConflict(HashMap<Integer,String> mapToCompare) {

        if(mapToCompare.size() >= 4 && this.dayList.size() >= 4) {
            return true;
        }

        Set<Integer> set1 = new HashSet<>();
        set1.addAll(this.dayList.keySet());

        Set<Integer> set2 = new HashSet<>();
        set2.addAll(mapToCompare.keySet());

        set1.removeAll(set2);

        if(set1.size() != this.dayList.keySet().size()) {
            return true;
        }
        else {
            return false;
        }
    }
}

