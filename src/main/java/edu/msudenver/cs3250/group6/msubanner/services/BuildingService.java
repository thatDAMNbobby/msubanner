package edu.msudenver.cs3250.group6.msubanner.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.repositories.BuildingRepository;

/**
 * Building service.
 */
@Service
public class BuildingService {


    /** The building repository. */
    @Autowired
    private BuildingRepository buildingRepository;

    /**
     * Gets the list of all buildings.
     * @return the list of all buildings
     */
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    /**
     * Gets a building by id.
     * @param id the building id
     * @return the building
     */
    public Building getBuilding(final String id) {
        return buildingRepository.findOne(id);
    }

    /**
     * Adds a building.
     * @param building the course to add
     */
    public void addBuilding(final Building building) {
        buildingRepository.save(building);
    }

    /**
     * Updates a building.
     * @param building the building to update
     */
    public void updateBuilding(final Building building) {
        buildingRepository.save(building);
    }

    /**
     * Deletes a building.
     * @param id the course id
     */
    public void deleteBuilding(final String id) {
        buildingRepository.delete(id);
    }
}
