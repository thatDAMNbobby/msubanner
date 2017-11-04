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
        System.out.print("test showing improper capitalization: ");
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
        semester.setSemesterStartDate(2018, 1, 12);

        assertEquals(semester.getSemesterYear(), semester.getSemesterStartDate().getYear());
        assertEquals("JANUARY", semester.getSemesterStartDate().getMonth().toString());
        assertEquals(12, semester.getSemesterStartDate().getDayOfMonth());
    }

    @Test
    public void setSemesterYearTest() {
        Semester semester = new Semester();
        semester.setSemesterYear(2019);

        assertEquals(2019, semester.getSemesterStartDate().getYear());
    }

    @Test
    public void semesterAlreadyExistsTestTrue() {
        Semester semester = new Semester();
        Semester semester2 = new Semester();

        assertEquals(true, semester.semesterAlreadyExists(semester2));
    }

    @Test
    public void semesterAlreadyExistsTestFalse() {
        Semester semester = new Semester();
        Semester semester2 = new Semester();
        semester2.setSeason("Spring");

        assertEquals(false, semester.semesterAlreadyExists(semester2));
    }

    @Test
    public void testAutoSetSeasonFall() {
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 9, 1);

        assertEquals("Fall", semester.getSeason());
    }

    @Test
    public void testAutoSetSeasonSpring() {
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 2, 1);

        assertEquals("Spring", semester.getSeason());
    }

    @Test
    public void testAutoSetSeasonSummer() {
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 7, 1);

        assertEquals("Summer", semester.getSeason());
    }
}