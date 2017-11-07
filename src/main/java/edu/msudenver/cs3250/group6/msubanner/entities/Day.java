package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.ArrayList;

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
        switch(this) {
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

    public static ArrayList<Day> getList(String[] days) {
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

}