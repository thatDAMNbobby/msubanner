package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;

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
    public void testBuildingParameterized() {
        Building testBuilding = new Building("awesome building");
        assertEquals("awesome building", testBuilding.getBuildingName());

    }

    @Test
    public void testBuildingNull() {
        Building testBuilding = new Building("");
        assertEquals("No building", testBuilding.getBuildingName());
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

    @Test(expected = IllegalArgumentException.class)
    public void setBuildingNameNull() {
        building.setBuildingName("");
    }

    @Test
    public void toStringTest() {
        String toStringResult = building.toString();

        assertEquals("Id: 1, Building Name: Test Name", building.toString());
        assertEquals(toStringResult, building.toString());

    }
}