package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import edu.msudenver.cs3250.group6.msubanner.entities.Days.Day;

public class DaysTest {

    @Test
    public void setId() {
        Days days = new Days();
        days.setId("1");
        assertEquals("1", days.getId());
    }

    @Test
    public void addDayToList() {
        Days days = new Days();

        assertTrue(days.getDayList().isEmpty());

        days.addToDayList(Day.MONDAY);
        days.addToDayList(Day.WEDNESDAY);

        assertTrue(days.getDayList().contains(Day.MONDAY));
        assertTrue(days.getDayList().contains(Day.WEDNESDAY));
        assertEquals(2, days.getDayList().size());
    }

    @Test
    public void testDuplicatesInDayList() {
        Days days = new Days();
        days.addToDayList(Day.SATURDAY);
        days.addToDayList(Day.SATURDAY);
        days.addToDayList(Day.SUNDAY);
        days.addToDayList(Day.SUNDAY);

        HashSet<Day> daysToTest = new HashSet<Day>();
        daysToTest.add(Day.SATURDAY);
        daysToTest.add(Day.SUNDAY);

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testDayListNotEqual() {
        Days days = new Days();
        days.addToDayList(Day.SATURDAY);
        days.addToDayList(Day.SUNDAY);

        HashSet<Day> daysToTest = new HashSet<Day>();
        daysToTest.add(Day.MONDAY);
        daysToTest.add(Day.WEDNESDAY);

        assertNotEquals(daysToTest, days.getDayList());
    }

    @Test
    public void testHasConflictTrue() {
        Days days = new Days();
        days.addToDayList(Day.SATURDAY);
        days.addToDayList(Day.MONDAY);

        HashSet<Day> daysToTest = new HashSet<Day>();
        daysToTest.add(Day.MONDAY);
        daysToTest.add(Day.WEDNESDAY);

        assertTrue(days.hasConflict(daysToTest));
    }

    @Test
    public void testHasConflictNull() {
        Days days = new Days();

        HashSet<Day> daysToTest = new HashSet<Day>();
        daysToTest.add(Day.MONDAY);
        daysToTest.add(Day.FRIDAY);

        assertFalse(days.hasConflict(daysToTest));
    }

    @Test
    public void testHasConflictNull2() {
        Days days = new Days();
        days.addToDayList(Day.MONDAY);
        days.addToDayList(Day.WEDNESDAY);

        HashSet<Day> daysToTest = new HashSet<Day>();

        assertFalse(days.hasConflict(daysToTest));
    }

    @Test
    public void testRemoveDayFromList() {
        Days days = new Days();
        days.addToDayList(Day.SATURDAY);
        days.addToDayList(Day.SUNDAY);
        days.addToDayList(Day.MONDAY);
        days.addToDayList(Day.TUESDAY);

        HashSet<Day> daysToTest = new HashSet<Day>();
        daysToTest.add(Day.SATURDAY);
        daysToTest.add(Day.SUNDAY);
        daysToTest.add(Day.TUESDAY);

        days.removeDayFromList(Day.MONDAY);

        assertEquals(daysToTest, days.getDayList());
    }

    @Test
    public void ToString() {
        Days days = new Days();
        days.addToDayList(Day.SATURDAY);
        days.addToDayList(Day.SUNDAY);
        days.addToDayList(Day.MONDAY);
        days.addToDayList(Day.TUESDAY);

        Days days2 = new Days();
        days2.addToDayList(Day.MONDAY);
        days2.addToDayList(Day.WEDNESDAY);
        days2.addToDayList(Day.THURSDAY);
        days2.addToDayList(Day.FRIDAY);

        HashSet<Day> daysToTest = new HashSet<Day>();
        daysToTest.add(Day.SATURDAY);
        daysToTest.add(Day.SUNDAY);
        daysToTest.add(Day.TUESDAY);

        days.removeDayFromList(Day.MONDAY);

        assertEquals("Sunday, Tuesday, Saturday", days.toString());
        assertEquals("Monday, Wednesday, Thursday, Friday", days2.toString());
    }

    @Test
    public void getListTest() {
        String[] testDays = new String[5];
        testDays[0] = "Monday";
        testDays[1] = "Tuesday";
        testDays[2] = "Wednesday";
        testDays[3] = "Thursday";
        testDays[4] = "Monday";

        List<Day> testList = new ArrayList<Day>();
        testList.add(Day.MONDAY);
        testList.add(Day.TUESDAY);
        testList.add(Day.WEDNESDAY);
        testList.add(Day.THURSDAY);

        assertEquals(testList, Days.getList(testDays));
    }
}
