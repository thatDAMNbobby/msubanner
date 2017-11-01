package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DaysTest {

    @Test
    public void SetIdSetIdTest() {
        Days days = new Days();
        days.setId("1");
        assertEquals("1", days.getId());
    }

    @Test
    public void testAddBadDayToDays() {
        Days days = new Days();
        days.addToDayList("Poo");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(3,"Poo");

        assertNotEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddSundayToDays() {
        Days days = new Days();
        days.addToDayList("Sunday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(1,"Sunday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddMondayToDays() {
        Days days = new Days();
        days.addToDayList("Monday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(2,"Monday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddTuesdayToDays() {
        Days days = new Days();
        days.addToDayList("Tuesday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(3,"Tuesday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddWednesdayToDays() {
        Days days = new Days();
        days.addToDayList("Wednesday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(4,"Wednesday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddThursdayToDays() {
        Days days = new Days();
        days.addToDayList("Thursday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(5,"Thursday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddFrdayToDays() {
        Days days = new Days();
        days.addToDayList("Friday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(6,"Friday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAddSaturdayToDays() {
        Days days = new Days();
        days.addToDayList("Saturday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(7,"Saturday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testDuplicatesInDayList() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Saturday");
        days.addToDayList("Sunday");
        days.addToDayList("Sunday");


        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(7,"Saturday");
        daysToTest.put(1,"Sunday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testDayListNotEqual() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Sunday");


        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(7,"Saturday");
        daysToTest.put(6,"Friday");

        assertNotEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testAllDays() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Sunday");
        days.addToDayList("Monday");
        days.addToDayList("Tuesday");
        days.addToDayList("Wednesday");
        days.addToDayList("Thursday");
        days.addToDayList("Friday");


        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(1,"Sunday");
        daysToTest.put(7,"Saturday");
        daysToTest.put(6,"Friday");
        daysToTest.put(2,"Monday");
        daysToTest.put(3,"Tuesday");
        daysToTest.put(4,"Wednesday");
        daysToTest.put(5,"Thursday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testHasConflictTrue() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Monday");


        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(2,"Monday");
        daysToTest.put(6,"Friday");

        assertEquals(true, days.hasConflict(daysToTest));
    }

    @Test
    public void testHasConflictNull() {
        Days days = new Days();

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(2,"Monday");
        daysToTest.put(6,"Friday");

        assertEquals(false, days.hasConflict(daysToTest));
    }

    @Test
    public void testFourDaysHasConflict() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Sunday");
        days.addToDayList("Monday");
        days.addToDayList("Tuesday");



        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(6,"Friday");
        daysToTest.put(2,"Monday");
        daysToTest.put(4,"Wednesday");
        daysToTest.put(5,"Thursday");

        assertEquals(true, days.hasConflict(daysToTest));
    }

    @Test
    public void testRemoveDayFromList() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Sunday");
        days.addToDayList("Monday");
        days.addToDayList("Tuesday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(7,"Saturday");
        daysToTest.put(1,"Sunday");
        daysToTest.put(3,"Tuesday");

        days.removeDayFromList("Monday");

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testRemoveDayFromListDayDoesntExist() {
        Days days = new Days();
        days.addToDayList("Saturday");
        days.addToDayList("Sunday");
        days.addToDayList("Tuesday");

        HashMap<Integer,String> daysToTest = new HashMap<Integer,String>();
        daysToTest.put(7,"Saturday");
        daysToTest.put(1,"Sunday");
        daysToTest.put(3,"Tuesday");

        days.removeDayFromList("Poo2");

        assertEquals(daysToTest, days.getDayList());
    }

}
