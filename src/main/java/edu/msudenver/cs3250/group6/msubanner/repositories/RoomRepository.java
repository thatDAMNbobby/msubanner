package edu.msudenver.cs3250.group6.msubanner.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Room;

import java.util.List;

/**
 * Room repository.
 */
@RepositoryRestResource
public interface RoomRepository extends MongoRepository<Room, String> {
    public Room findById(String id);
    public List<Room> findAll();

}
