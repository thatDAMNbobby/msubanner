package edu.msudenver.cs3250.group6.msubanner;

/**
 * Department abbreviations.
 */
public enum DepartmentAbbr {
    /** Computer Science department abbreviation. */
    CS("CS"),
    /** Mathematics department abbreviation. */
    MTH("MTH"),
    /** Computer Information Systems department abbreviation. */
    CIS("CIS");

    /** Display name. */
    private String myDisplayName;

    /**
     * Constructor for department abbreviation.
     * @param displayName the display name
     */
    DepartmentAbbr(final String displayName) {
        myDisplayName = displayName;
    }

    /**
     * Gets the display name.
     * @return the display name
     */
    public String getDisplayName() {
        return myDisplayName;
    }

    @Override
    public String toString() {
        return myDisplayName;
    }
}
