package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScheduleTest {
    @Before
    public void initialize() {
        Building building2 = new Building( "Temptation of the Ceiling Cat");

        Room room3 = new Room(256, 255, building2);

        Semester semester2 = new Semester();
        semester2.setSemesterStartDate(2020,1,15);

        List<Day> days2 = new ArrayList<>(Arrays.asList(new Day[] {Day.SUNDAY, Day.FRIDAY}));

        int duration2 = 3;

    }

    @Test
    public void scheduleDefaultConstructor() {
        Schedule schedule = new Schedule();
        assertNotNull(schedule);
    }

    @Test
    public void scheduleParameterizedConstructor1() {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019,6,15);
        int duration1 = 2;
        List<Day> days1 = new ArrayList<>(Arrays.asList(new Day[] {Day.MONDAY, Day.WEDNESDAY}));
        String hours1 = "3";
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1, startDate1, duration1, days1, hours1);

        assertNotNull(schedule);
    }

    @Test(expected = IllegalArgumentException.class)
    public void scheduleParameterizedConstructor1Duration() {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019,6,15);
        int duration1 = 0;
        List<Day> days1 = new ArrayList<>(Arrays.asList(new Day[] {Day.MONDAY, Day.WEDNESDAY}));
        String hours1 = "3";
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1, startDate1, duration1, days1, hours1);

        assertNotNull(schedule);
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