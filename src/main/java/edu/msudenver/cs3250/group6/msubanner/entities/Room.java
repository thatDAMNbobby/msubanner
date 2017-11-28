package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Room class.
 */
public class Room {

    /**
     * Room id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String myId;

    /**
     * Room number.
     */
    @Column
    private int myRoomNumber;

    /**
     * Room Capacity.
     */
    private int myCapacity;

    /**
     * Building.
     */
    private Building myBuilding;

    /**
     * Default Constructor.
     */
    public Room() {
        myRoomNumber = 0;
        myCapacity = 0;
        myBuilding = new Building();
    }

    /**
     * Constructor.
     *
     * @param roomNumber the room number
     * @param roomCapacity the room capacity
     * @param building the building the room is in
     */
    public Room(final int roomNumber, final int roomCapacity,
            final Building building) {

        if (roomNumber < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.myRoomNumber = roomNumber;
        }

        if (roomCapacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            myCapacity = roomCapacity;
        }

        if (building == null) {
            throw new IllegalArgumentException("Building cannot be null");
        } else {
            this.myBuilding = building;
        }
    }

    /**
     * Sets the id of the room.
     *
     * @param id New id for the room
     */
    public void setId(final String id) {
        this.myId = id;
    }

    /**
     * Returns the id number of the room.
     *
     * @return id number of the room
     */
    public String getId() {
        return myId;
    }

    /**
     * Sets the name of the room.
     *
     * @param roomNumber New roomNumber of the room.
     * @throws IllegalArgumentException if new roomNumber is blank
     */
    public void setRoomNumber(final int roomNumber)
            throws IllegalArgumentException {
        if (roomNumber < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.myRoomNumber = roomNumber;
        }
    }

    /**
     * Sets the room's capacity.
     *
     * @param capacity Capacity of the room
     * @throws IllegalArgumentException if capacity is negative
     */
    public void setRoomCapacity(final int capacity)
            throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.myCapacity = capacity;
        }
    }

    /**
     * Sets the building this room is in.
     *
     * @param building new building containing this room
     * @throws IllegalArgumentException id building is null
     */
    public void setBuilding(final Building building)
            throws IllegalArgumentException {
        if (building == null) {
            throw new IllegalArgumentException("Building cannot be null");
        } else {
            this.myBuilding = building;
        }
    }

    /**
     * Returns the name of the room.
     *
     * @return Name of the room
     */
    public int getRoomNumber() {
        return myRoomNumber;
    }

    /**
     * Returns the capacity of the room.
     *
     * @return Capacity of the room
     */
    public int getRoomCapacity() {
        return myCapacity;
    }

    /**
     * Returns the building that contains this room.
     *
     * @return Building containing this room
     */
    public Building getBuilding() {
        return myBuilding;
    }

    /**
     * toString method for Room.
     */
    @Override
    public String toString() {
        return "Id: " + this.getId() + ", Room Number: " + this.getRoomNumber()
                + ", Building: " + this.getBuilding() + ", Capacity: "
                + this.getRoomCapacity();

    }
}
