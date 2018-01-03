package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Room;

/**
 * Room repository.
 */
@RepositoryRestResource
public interface RoomRepository extends MongoRepository<Room, String> {
    /**
     * Finds a room by id.
     *
     * @param id the room id
     * @return the room
     */
    Room findById(String id);

    /**
     * Finds all rooms.
     *
     * @return the list of all rooms
     */
    List<Room> findAll();
}
