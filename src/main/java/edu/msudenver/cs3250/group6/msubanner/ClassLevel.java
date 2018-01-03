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
    SENIOR("Senior", 90),
    /** Graduate class level. */
    GRADUATE("Graduate", 120);
    /** Display name. */
    private String displayName;

    /** Minimum number of credits completed. */
    private int minCredits;

    /**
     * Constructor for class level.
     * @param newName the display name
     * @param newMinCredits the min number of credits completed
     */
    ClassLevel(final String newName, final int newMinCredits) {
        this.displayName = newName;
        this.minCredits = newMinCredits;
    }

    /**
     * Gets the display name.
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets the minimum number of credits completed.
     * @return the minimum credits completed
     */
    public int getMinCredits() {
        return minCredits;
    }

    @Override
    public String toString() {
        return displayName + ": " + minCredits + " minimum credits";
    }
}
