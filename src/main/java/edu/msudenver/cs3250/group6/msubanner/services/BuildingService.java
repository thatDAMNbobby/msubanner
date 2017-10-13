package edu.msudenver.cs3250.group6.msubanner.services;


import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<Building> buildings = new ArrayList<>();
        // populate the course list with each element in the repository
        buildingRepository.findAll().forEach(buildings::add);
        return buildings;
    }

    /**
     * Gets a building by id.
     * @param id the building id
     * @return the building
     */
    public Building getBuilding(final long id) {
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
    public void deleteBuilding(final long id) {
        buildingRepository.delete(id);
    }
}
