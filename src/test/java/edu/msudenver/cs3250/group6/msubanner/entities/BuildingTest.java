package edu.msudenver.cs3250.group6.msubanner.entities;

import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingTest {

    private BuildingService buildingService = new BuildingService();
    private Building building;

    @Before
    public void before() {
         building = new Building();
         building.setBuildingName("Test Name");
         building.setId("1");
    }

    @Test
    public void testSetId() {
        building.setId("0");
        assertEquals("0", building.getId());
    }

    @Test
    public void testSetBuildingName() {
        building.setBuildingName("some building");
        assertEquals("some building", building.getBuildingName());
    }

    @Test
    public void testBuildingNameNotNull() {
        assertNotNull(building.getBuildingName());
    }

}