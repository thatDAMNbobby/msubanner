package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class SemesterTest {

    @Test
    public void setIdTest() {
        Semester semester = new Semester();
        semester.setId("1");
        assertEquals("1", semester.getId());
    }

    @Test
    public void setSeasonTestFallFail() {
        Semester semester = new Semester();
        semester.setSeason("fall");

        assertEquals("Season Not Set", semester.getSeason());
    }

    @Test
    public void setSeasonTestFall() {
        Semester semester = new Semester();
        semester.setSeason("Fall");

        assertEquals("Fall", semester.getSeason());
    }

    @Test
    public void setSeasonTestSpring() {
        Semester semester = new Semester();
        semester.setSeason("Spring");

        assertEquals("Spring", semester.getSeason());
    }

    @Test
    public void setSeasonTestSummer() {
        Semester semester = new Semester();
        semester.setSeason("Summer");

        assertEquals("Summer", semester.getSeason());
    }

    @Test
    public void setSemesterStartDateTest() {
        Semester semester = new Semester();
        semester.setSeasonStartDate(2018, 1, 12);

        assertEquals("Friday, January 12, 2018", semester.getSemesterStartDate());
    }

}