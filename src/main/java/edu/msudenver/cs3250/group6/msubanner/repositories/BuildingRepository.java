package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Building repository.
 */
@RepositoryRestResource
public interface BuildingRepository extends MongoRepository<Building, String> {
    public Building findById(String id);
    public List<Building> findAll();
}
