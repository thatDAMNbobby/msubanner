package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Building;

/**
 * Building repository.
 */
@RepositoryRestResource
public interface BuildingRepository extends MongoRepository<Building, String> {
    /**
     * Finds the building by id.
     *
     * @param id the building id
     * @return the building
     */
    Building findById(String id);

    /**
     * Finds all buildings.
     *
     * @return the list of buildings
     */
    List<Building> findAll();
}
