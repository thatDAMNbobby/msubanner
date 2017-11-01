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
     * Default Constructor.
     */
    public Room() {
        this.roomNumber = 0;
    }

    /**
     * Constructor.
     *
     * @param roomNumber the room number
     * @param roomCapacity the room capacity
     */
    public Room(final int roomNumber, final int roomCapacity) {

        if (roomNumber < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.roomNumber = roomNumber;
        }

        if (roomCapacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            capacity = roomCapacity;
        }
    }

    /**
     * Sets the id of the room.
     *
     * @param id New id for the room
     */
    public void setId(final String id) {
        this.id = id;
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
     * @param roomNumber New roomNumber of the room.
     * @throws IllegalArgumentException if new roomNumber is blank
     */
    public void setRoomNumber(final int roomNumber)
            throws IllegalArgumentException {
        if (roomNumber < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.roomNumber = roomNumber;
        }
    }

    /**
     * Sets the room's capacity.
     * @param capacity Capacity of the room
     * @throws IllegalArgumentException if capacity is negative
     */
    public void setRoomCapacity(final int capacity)
            throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException("Stay positive");
        } else {
            this.capacity = capacity;
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
     * toString method for Room.
     */
    @Override
    public String toString() {
        return "Building{" + "Id=" + id + ", Title= " + roomNumber + " }";
    }
}
