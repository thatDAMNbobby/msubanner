package edu.msudenver.cs3250.group6.msubanner;

/*
 * References:
 * ibrahim-2017.blogspot.com/2017/03/java-enums-how-to-use-them.html
 */

/**
 * Valid class levels.
 */
public enum ClassLevel {
    /** Freshman class level. */
    FRESHMAN("Freshman", 0),
    /** Sophomore class level. */
    SOPHOMORE("Sophomore", 30),
    /** Junior class level. */
    JUNIOR("Junior", 60),
    /** Senior class level. */
    SENIOR("Senior", 90);

    /** Display name. */
    private String myDisplayName;

    /** Minimum number of credits completed. */
    private int myMinCredits;

    /**
     * Constructor for class level.
     * @param displayName the display name
     * @param minCredits the min number of credits completed
     */
    ClassLevel(final String displayName, final int minCredits) {
        myDisplayName = displayName;
        myMinCredits = minCredits;
    }

    /**
     * Gets the display name.
     * @return the display name
     */
    public String getDisplayName() {
        return myDisplayName;
    }

    /**
     * Gets the minimum number of credits completed.
     * @return the minimum credits completed
     */
    public int getMinCredits() {
        return myMinCredits;
    }

    @Override
    public String toString() {
        return myDisplayName + ": " + myMinCredits + " minimum credits";
    }
}
