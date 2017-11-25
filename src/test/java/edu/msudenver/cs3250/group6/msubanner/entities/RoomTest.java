package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
    @Test
    public void setIdTest() throws Exception {
        Room room = new Room();
        room.setId("5656");
        assertEquals("5656", room.getId());
    }

    @Test
    public void getId() throws Exception {
        Room room = new Room();
        String roomId = room.getId();
        assertEquals(roomId, room.getId());
    }

    @Test
    public void setRoomNumber() throws Exception {
        Room room = new Room();
        room.setRoomNumber(249);
        assertEquals(249, room.getRoomNumber());

    }

    @Test
    public void setRoomCapacity() throws Exception {
        Room room = new Room();
        room.setRoomCapacity(249);
        assertEquals(249, room.getRoomCapacity());
    }

    @Test
    public void setBuilding() throws Exception {
        Building building = new Building("The Bat Cave");
        Building building2 = building;

        Room room = new Room();
        room.setBuilding(building);

        assertEquals(building2, room.getBuilding());
    }

    @Test
    public void getRoomNumber() throws Exception {
        Room room = new Room();
        room.setRoomNumber(249);
        int roomNumber = 249;
        assertEquals(roomNumber, room.getRoomNumber());
    }

    @Test
    public void getRoomCapacity() throws Exception {
        Room room = new Room();
        room.setRoomCapacity(249);
        int roomCapacity = 249;
        assertEquals(roomCapacity, room.getRoomCapacity());
    }

    @Test
    public void getBuilding() throws Exception {
        Building building = new Building("The Cat Cave");
        Building building2 = building;

        Room room = new Room();
        room.setBuilding(building);

        assertEquals(building2, room.getBuilding());
    }

    @Test
    public void toStringTest() throws Exception {
        Room room = new Room();
        Building building = new Building("The Cat Cave");
        room.setId("5656");
        room.setBuilding(building);
        room.setRoomCapacity(256);
        room.setRoomNumber(255);

        assertEquals("Id: 5656, Room Number: 255, Building: Id: null, Building Name: The Cat Cave, Capacity: 256", room.toString() );
    }

}