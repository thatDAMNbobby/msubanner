package edu.msudenver.cs3250.group6.msubanner.controllers;


import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The controller for the building class.
 */
@RestController
public class BuildingController {

    /** The building service. */
    @Autowired
    private BuildingService buildingService;

    /**
     * Gets the list of all buildings.
     * @return the list of all buildings
     */
    @RequestMapping("/buildings")
    public List<Building> getAllBuildings(){
        return buildingService.getAllBuildings(); }

    /**
     * Gets a building by id number.
     * @param id the building id
     * @return the building
     */
    @RequestMapping("/buildings/getbuilding/{id}")
    public Building getBuilding(@PathVariable final long id){ return buildingService.getBuilding(id);}

    /**
     * Adds a building.
     * @param building the building to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/buildings/addbuilding")
    // take request body, turn into Building instance and pass to addBuilding()
    public void addBuilding(@RequestBody final Building building) {
        // POST body should contain object being sent
        buildingService.addBuilding(building);
    }

    /**
     * Updates a building.
     * @param building the building to be updated
     * @param id the building's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/buildings/updatebuilding/{id}")
    // take request body, turn into Building instance and pass to addBuilding()
    public void updateBuilding(@RequestBody final Building building,
                             @PathVariable final long id) {
        // POST body should contain object being sent
        buildingService.updateBuilding(building);
    }

    /**
     * Deletes a building.
     * @param id the building's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/buildings/deletebuilding/{id}")
    public void deleteBuilding(@PathVariable final long id) {
        // @PathVariable indicates use of wildcard above
        buildingService.deleteBuilding(id);
    }
}
