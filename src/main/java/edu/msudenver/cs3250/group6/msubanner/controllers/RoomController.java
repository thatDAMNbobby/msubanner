package edu.msudenver.cs3250.group6.msubanner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.services.RoomService;

/**
 * The controller for the room class.
 */
@RestController
public class RoomController {

    /**
     * The room service.
     */
    @Autowired
    private RoomService roomService;

    /**
     * Gets the list of all rooms.
     *
     * @return the list of all rooms
     */
    @RequestMapping("/rooms")
    public List<Room> getAllRooms() {

        return roomService.getAllRooms();
    }

    /**
     * Gets a room by id number.
     *
     * @param id the room id
     * @return the room
     */
    @RequestMapping("/rooms/getroom/{id}")
    public Room getRoom(@PathVariable final long id) {
        return roomService.getRoom(id);
    }

    /**
     * Adds a room.
     *
     * @param roomNumber the room number
     * @param roomCapacity the room capacity
     * @return the room
     */
    @RequestMapping(method = RequestMethod.POST, value = "/rooms/addroom")
    public ResponseEntity<Room> addRoom(@RequestParam final int roomNumber,
            final int roomCapacity) {
        Room room = new Room(roomNumber, roomCapacity);
        roomService.addRoom(room);
        return new ResponseEntity<Room>(room, HttpStatus.CREATED);
    }

    /**
     * Updates a course.
     *
     * @param room the room to be updated
     * @param id the room's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/rooms/updateroom/{id}")
    public void updateRoom(@RequestBody final Room room,
            @PathVariable final long id) {
        roomService.updateRoom(room);
    }

    /**
     * Deletes a course.
     *
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/rooms/deleteroom/{id}")
    public void deleteRoom(@PathVariable final long id) {
        roomService.deleteRoom(id);
    }
}
