package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class SemesterTest {

    @Test
    public void setIdTest() {
        System.out.println("\n" +
                           "\n-----------------------------------" +
                           "\nTesting Semester Id" +
                           "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setId("1");
        assertEquals("1", semester.getId());
    }

    @Test
    public void setIdTest2() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester Id 2" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setId("3");
        assertEquals("3", semester.getId());
    }

    @Test
    public void setSeasonTestFallWarn() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSeason()  should warn" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setId("1");
        semester.setSeason("fall");

        Semester semester1 = new Semester();
        assertEquals(semester1.getSeason(), semester.getSeason());
    }

    @Test
    public void setSeasonTestFall() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSeason() Fall" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSeason("Fall");

        assertEquals("Fall", semester.getSeason());
    }

    @Test
    public void setSeasonTestSpring() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSeason() Spring" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSeason("Spring");

        assertEquals("Spring", semester.getSeason());
    }

    @Test
    public void setSeasonTestSummer() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSeason() Summer" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSeason("Summer");

        assertEquals("Summer", semester.getSeason());
    }

    @Test
    public void setSemesterStartDateTest() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSemesterStartDate()" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2018, 1, 12);

        assertEquals(semester.getSemesterYear(), semester.getSemesterStartDate().getYear());
        assertEquals("JANUARY", semester.getSemesterStartDate().getMonth().toString());
        assertEquals(12, semester.getSemesterStartDate().getDayOfMonth());
    }

    @Test
    public void setSemesterEndDateTest() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSemesterEndDate()" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSemesterEndDate(2020, 9, 15);

        assertEquals(2020, semester.getSemesterEndDate().getYear());
        assertEquals("SEPTEMBER", semester.getSemesterEndDate().getMonth().toString());
        assertEquals(15, semester.getSemesterEndDate().getDayOfMonth());
    }

    @Test
    public void testAutoSemesterEndDate() {
        System.out.println("\n" +
                "\n-------------------------------------------------------" +
                "\nTesting Semester Auto initialization of semesterEndDate" +
                "\n-------------------------------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 6, 10);

        assertEquals(2020, semester.getSemesterEndDate().getYear());
        assertEquals("SEPTEMBER", semester.getSemesterEndDate().getMonth().toString());
        assertEquals(25, semester.getSemesterEndDate().getDayOfMonth());
    }

    @Test
    public void testAutoSemesterEndDateIncreaseYear() {
        System.out.println("\n" +
                "\n----------------------------------------------------------------------" +
                "\nTesting Semester Auto initialization of semesterEndDate with month > 9" +
                "\n----------------------------------------------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 10, 10);
        // semester.setSemesterEndDate(2020, 9, 25);

        assertEquals(2021, semester.getSemesterEndDate().getYear());
        assertEquals("JANUARY", semester.getSemesterEndDate().getMonth().toString());
        assertEquals(25, semester.getSemesterEndDate().getDayOfMonth());
    }

    @Test
    public void setSemesterEndDateTestWarn() {
        System.out.println("\n" +
                "\n-------------------------------------------" +
                "\nTesting Semester setSemesterEndDate()  Warn" +
                "\n-------------------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 9, 15);
        semester.setSemesterEndDate(2010, 9, 15);

        assertEquals(2020, semester.getSemesterStartDate().getYear());
        assertEquals(2020, semester.getSemesterEndDate().getYear());
        assertEquals("DECEMBER", semester.getSemesterEndDate().getMonth().toString());
        assertEquals(25, semester.getSemesterEndDate().getDayOfMonth());
    }

    @Test
    public void setSemesterYearTest() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester setSemesterYear()" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSemesterYear(2019);

        assertEquals(2019, semester.getSemesterYear());
    }

    @Test
    public void semesterAlreadyExistsTestTrue() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester hasConflict() true" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        Semester semester2 = new Semester();

        assertEquals(true, semester.hasConflict(semester2));
    }

    @Test
    public void semesterAlreadyExistsTestFalse() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester hasConflict() false" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setId("1");
        Semester semester2 = new Semester();
        semester2.setSeason("Spring");
        semester2.setId("2");
        assertEquals(false, semester.hasConflict(semester2));
    }

    @Test
    public void testAutoSetSeasonFall() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester autoSetSeason() Fall" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 9, 1);

        assertEquals("Fall", semester.getSeason());
    }

    @Test
    public void testAutoSetSeasonSpring() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester autoSetSeason() Spring" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 2, 1);

        assertEquals("Spring", semester.getSeason());
    }

    @Test
    public void testAutoSetSeasonSummer() {
        System.out.println("\n" +
                "\n-----------------------------------" +
                "\nTesting Semester autoSetSeason() Summer" +
                "\n-----------------------------------");
        Semester semester = new Semester();
        semester.setSemesterStartDate(2020, 7, 1);

        assertEquals("Summer", semester.getSeason());
    }

}