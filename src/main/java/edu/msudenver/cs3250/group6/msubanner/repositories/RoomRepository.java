package edu.msudenver.cs3250.group6.msubanner.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Room;

/**
 * Room repository.
 */
@RepositoryRestResource
public interface RoomRepository extends CrudRepository<Room, Long> {

}
