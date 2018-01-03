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
    private String id;

    /**
     * Room number.
     */
    @Column
    private int roomNumber;

    /**
     * Room Capacity.
     */
    private int capacity;

    /**
     * Building.
     */
    private Building building;

    /**
     * Default Constructor.
     */
    public Room() {
        roomNumber = 0;
        capacity = 0;
        building = new Building();
    }

    /**
     * Constructor.
     *
     * @param newRoomNo the room number
     * @param roomCapacity the room capacity
     * @param newBuilding the building the room is in
     */
    public Room(final int newRoomNo, final int roomCapacity,
            final Building newBuilding) {

        if (newRoomNo < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.roomNumber = newRoomNo;
        }

        if (roomCapacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            capacity = roomCapacity;
        }

        if (newBuilding == null) {
            throw new IllegalArgumentException("Building cannot be null");
        } else {
            this.building = newBuilding;
        }
    }

    /**
     * Sets the id of the room.
     *
     * @param newId New id for the room
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Returns the id number of the room.
     *
     * @return id number of the room
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the name of the room.
     *
     * @param newRoomNo New roomNumber of the room.
     * @throws IllegalArgumentException if new roomNumber is blank
     */
    public void setRoomNumber(final int newRoomNo)
            throws IllegalArgumentException {
        if (newRoomNo < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.roomNumber = newRoomNo;
        }
    }

    /**
     * Sets the room's capacity.
     *
     * @param newCapacity Capacity of the room
     * @throws IllegalArgumentException if capacity is negative
     */
    public void setRoomCapacity(final int newCapacity)
            throws IllegalArgumentException {
        if (newCapacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.capacity = newCapacity;
        }
    }

    /**
     * Sets the building this room is in.
     *
     * @param newBuilding new building containing this room
     * @throws IllegalArgumentException id building is null
     */
    public void setBuilding(final Building newBuilding)
            throws IllegalArgumentException {
        if (newBuilding == null) {
            throw new IllegalArgumentException("Building cannot be null");
        } else {
            this.building = newBuilding;
        }
    }

    /**
     * Returns the name of the room.
     *
     * @return Name of the room
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Returns the capacity of the room.
     *
     * @return Capacity of the room
     */
    public int getRoomCapacity() {
        return capacity;
    }

    /**
     * Returns the building that contains this room.
     *
     * @return Building containing this room
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * toString method for Room.
     */
    @Override
    public String toString() {
        return "Id: " + id + ", Room Number: " + roomNumber + ", Building: "
                + building + ", Capacity: " + capacity;
    }
}
