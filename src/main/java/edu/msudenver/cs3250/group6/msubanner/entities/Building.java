package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent Building class.
 */
@Entity
@Table(name = "buildings")
public class Building {

    /**
     * Building id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;
    
    /**
     * Name of the building.
     */
    @Column
    private String myBuildingName;


    //private Room myRooms;

    /**
     * Default Constructor
     */
    public Building(){
        this.myBuildingName = "No building";
    }
    
    public Building(final String buildingName ) {
       
        if (buildingName == null || buildingName.isEmpty()) {
            myBuildingName = "No building";
        } else {
            myBuildingName = buildingName;
        }
    }

    /**
     * Sets the id of the building.
     * @param id New id for the building
     */
    public void setId(final long id) {
        if (id > 0) {
            myId = id;
        }
    }

    /**
     * Returns the id number of the building.
     * @return id number of the building
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the name of the building.
     * @param buildingName New buildingName of the building.
     * @throws IllegalArgumentException if new buildingName is blank
     */
    public void setBuildingName(final String buildingName) throws IllegalArgumentException {
        if (buildingName == null || buildingName.isEmpty()) {
            throw new IllegalArgumentException("Building name cannot be blank.");
        }
        this.myBuildingName = buildingName;
    }

    /**
     * Returns the name of the building.
     * @return Name of the building
     */
    public String getBuildingName() {
        return myBuildingName;
    }

    /**
     * toString method for Building.
     */
    @Override
    public String toString() {
        return "Building{" + "Id=" + myId + ", Title= " + myBuildingName
                + ", Description=   }";
    }
}
