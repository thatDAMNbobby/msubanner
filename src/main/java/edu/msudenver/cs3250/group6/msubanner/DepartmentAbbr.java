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
    private String displayName;

    /**
     * Constructor for department abbreviation.
     * @param newName the display name
     */
    DepartmentAbbr(final String newName) {
        displayName = newName;
    }

    /**
     * Gets the display name.
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
