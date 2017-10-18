package edu.msudenver.cs3250.group6.msubanner.controllers;


import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * The controller for the building class.
 */
@Controller
public class BuildingController {

    /** The building service. */
    @Autowired
    private BuildingService buildingService;

    /**
     * Gets the list of all buildings.
     * @return the list of all buildings
     */
    @RequestMapping("/buildings")
    public ModelAndView getAllBuildings(){
        ModelAndView mav = new ModelAndView("buildings");
        mav.addObject("allbuildings", buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a building by id number.
     * @param id the building id
     * @return the building
     */
    @RequestMapping("/buildings/getbuilding/{id}")
    public ModelAndView getBuilding(@PathVariable final long id){
        ModelAndView mav = new ModelAndView("showbuilding");
        mav.addObject("building", buildingService.getBuilding(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;}

    /**
     * Adds a building.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/buildings/addbuilding")
    public ModelAndView addBuilding(@RequestParam final String buildingName) {
        Building building = new Building(buildingName);
        buildingService.addBuilding(building);
        ModelAndView mav = new ModelAndView("showbuilding");
        mav.addObject("building", building);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
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
    @RequestMapping(method = RequestMethod.GET,
            value = "/buildings/deletebuilding/{id}")
    public ModelAndView deleteBuilding(@PathVariable final long id) {
        buildingService.deleteBuilding(id);
        ModelAndView mav = new ModelAndView("buildings");
        mav.addObject("allbuildings", buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
