package edu.msudenver.cs3250.group6.msubanner;

/**
 * Global class to hold global variables for msubanner project.
 */
public final class Global {
    /**Global School Name. */

    public static final String SCHOOL_NAME = "MSUDENVER";

    /**
     * Constructor to prevent instantiation.
     * @throws AssertionError if the constructor is called
     */
    private Global() throws AssertionError {
        throw new AssertionError("Instantiating a utility class.");
    }
}
