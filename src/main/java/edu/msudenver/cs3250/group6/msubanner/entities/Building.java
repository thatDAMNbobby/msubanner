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

    // private Room myRooms;

    /**
     * Default Constructor.
     */
    public Building() {
        this.buildingName = "No building";
    }

    /**
     * Constructor.
     *
     * @param buildingName the building name
     */
    public Building(final String buildingName) {

        if (buildingName == null || buildingName.isEmpty()) {
            this.buildingName = "No building";
        } else {
            this.buildingName = buildingName;
        }
    }

    /**
     * Sets the id of the building.
     *
     * @param id New id for the building
     */
    public void setId(final String id) {
        this.id = id;
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
     * @param buildingName New buildingName of the building.
     * @throws IllegalArgumentException if new buildingName is blank
     */
    public void setBuildingName(final String buildingName)
            throws IllegalArgumentException {
        if (buildingName == null || buildingName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Building name cannot be blank.");
        }
        this.buildingName = buildingName;
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
