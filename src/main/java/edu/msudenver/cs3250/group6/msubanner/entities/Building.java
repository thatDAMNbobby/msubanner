package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Building class.
 */
public class Building {

    /**
     * Building id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * Name of the building.
     */
    @Column
    private String buildingName;

    /**
     * Default Constructor.
     */
    public Building() {
        this.buildingName = "No building";
    }

    /**
     * Constructor.
     *
     * @param newBuildingName the building name
     */
    public Building(final String newBuildingName) {

        if (newBuildingName == null || newBuildingName.isEmpty()) {
            this.buildingName = "No building";
        } else {
            this.buildingName = newBuildingName;
        }
    }

    /**
     * Sets the id of the building.
     *
     * @param newId New id for the building
     */
    public void setId(final String newId) {
        if (newId != null) {
            this.id = newId;
        }
    }

    /**
     * Returns the id number of the building.
     *
     * @return id number of the building
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the name of the building.
     *
     * @param newBuildingName New buildingName of the building.
     * @throws IllegalArgumentException if new buildingName is blank
     */
    public void setBuildingName(final String newBuildingName)
            throws IllegalArgumentException {
        if (newBuildingName == null || newBuildingName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Building name cannot be blank.");
        }
        this.buildingName = newBuildingName;
    }

    /**
     * Returns the name of the building.
     *
     * @return Name of the building
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * toString method for Building.
     */
    @Override
    public String toString() {
        return "Id: " + id + ", Building Name: " + buildingName;
    }
}
