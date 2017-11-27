package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduleTest {
    @Before
    public void initialize() {
        Building building1 = new Building("House of Cats");
        Building building2 = new Building( "Temptation of the Ceiling Cat");

        Room room1 = new Room(256, 255, building1);
        Room room2 = new Room(156, 255, building1);
        Room room3 = new Room(256, 255, building2);

        Semester semester1 = new Semester();
        Semester semester2 = new Semester();
        semester1.setSemesterStartDate(2019,6,15);
        semester2.setSemesterStartDate(2020,1,15);

    }

    @Test
    public void getDays() throws Exception {
    }

    @Test
    public void setDays() throws Exception {
    }

    @Test
    public void getSemester() throws Exception {
    }

    @Test
    public void setSemester() throws Exception {
    }

    @Test
    public void getId() throws Exception {
    }

    @Test
    public void getStartDate() throws Exception {
    }

    @Test
    public void setStartDate() throws Exception {
    }

    @Test
    public void setId() throws Exception {
    }

    @Test
    public void getRoom() throws Exception {
    }

    @Test
    public void setRoom() throws Exception {
    }

    @Test
    public void getBuilding() throws Exception {
    }

    @Test
    public void setBuilding() throws Exception {
    }

    @Test
    public void getHours() throws Exception {
    }

    @Test
    public void setHours() throws Exception {
    }

    @Test
    public void getDuration() throws Exception {
    }

    @Test
    public void setDuration() throws Exception {
    }

    @Test
    public void getHourBlock() throws Exception {
    }

    @Test
    public void setHourBlock() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }

    @Test
    public void setScheduleName() throws Exception {
    }
//
//    @Test
//    public void toString() throws Exception {
//    }

}