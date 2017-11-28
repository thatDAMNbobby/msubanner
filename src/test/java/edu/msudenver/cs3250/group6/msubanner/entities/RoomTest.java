package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoomTest {

    @Test
    public void basicConstructorTest() {
        Room testRoom = new Room();
        assertEquals(0, testRoom.getRoomNumber());
        assertEquals(0, testRoom.getRoomCapacity());
        assertEquals("No building", testRoom.getBuilding().getBuildingName());
    }

    @Test
    public void fullConstructorTest() {
        Room testRoom = new Room(1001, 35, new Building("Science"));
        assertEquals(1001, testRoom.getRoomNumber());
        assertEquals(35, testRoom.getRoomCapacity());
        assertEquals("Science", testRoom.getBuilding().getBuildingName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void badRoomNumTest() {
        Room badRoom = new Room(-1, 35, new Building("Science"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void badRoomCapacityTest() {
        Room badRoom = new Room(1001, -2, new Building("Science"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void badRoomBuildingTest() {
        Room badRoom = new Room(1001, 35, null);
    }

    @Test
    public void setIdTest()  {
        Room room = new Room();
        room.setId("5656");
        assertEquals("5656", room.getId());
    }

    @Test
    public void getId()  {
        Room room = new Room();
        String roomId = room.getId();
        assertEquals(roomId, room.getId());
    }

    @Test
    public void setRoomNumber()  {
        Room room = new Room();
        room.setRoomNumber(249);
        assertEquals(249, room.getRoomNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBadRoomNum() {
        Room room = new Room();
        room.setRoomNumber(-12);
    }

    @Test
    public void setRoomCapacity()  {
        Room room = new Room();
        room.setRoomCapacity(249);
        assertEquals(249, room.getRoomCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBadRoomCapacity() {
        Room room = new Room();
        room.setRoomCapacity(-12);
    }

    @Test
    public void setBuilding()  {
        Building building = new Building("The Bat Cave");
        Building building2 = building;

        Room room = new Room();
        room.setBuilding(building);

        assertEquals(building2, room.getBuilding());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBadRoomBuilding() {
        Room room = new Room();
        room.setBuilding(null);
    }

    @Test
    public void getRoomNumber()  {
        Room room = new Room();
        room.setRoomNumber(249);
        int roomNumber = 249;
        assertEquals(roomNumber, room.getRoomNumber());
    }

    @Test
    public void getRoomCapacity()  {
        Room room = new Room();
        room.setRoomCapacity(249);
        int roomCapacity = 249;
        assertEquals(roomCapacity, room.getRoomCapacity());
    }

    @Test
    public void getBuilding()  {
        Building building = new Building("The Cat Cave");
        Building building2 = building;

        Room room = new Room();
        room.setBuilding(building);

        assertEquals(building2, room.getBuilding());
    }

    @Test
    public void toStringTest()  {
        Room room = new Room();
        Building building = new Building("The Cat Cave");
        room.setId("5656");
        room.setBuilding(building);
        room.setRoomCapacity(256);
        room.setRoomNumber(255);

        assertEquals(
                "Id: 5656, Room Number: 255, Building: Id: null, Building Name: The Cat Cave, Capacity: 256",
                room.toString());
    }

}