package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ScheduleTest {

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
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        String hours1 = "3";
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);

        assertNotNull(schedule);
        assertEquals(building1, schedule.getBuilding());
        assertEquals(room1, schedule.getRoom());
        assertEquals(semester1, schedule.getSemester());
        assertEquals("2020/03/27", schedule.getStartDate());
        assertEquals(days1, schedule.getDays());
        assertEquals(hours1, schedule.getHours());
        assertEquals(duration1, schedule.getDuration());
    }

    @Test(expected = IllegalArgumentException.class)
    public void scheduleParameterizedConstructor1Duration() {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 0;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        String hours1 = "3";
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);

        assertNotNull(schedule);
    }

    @Test
    public void scheduleParameterizedConstructor2() {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);

        assertNotNull(schedule);
        assertEquals(building1, schedule.getBuilding());
        assertEquals(room1, schedule.getRoom());
        assertEquals(semester1, schedule.getSemester());
        assertEquals("2020/03/27", schedule.getStartDate());
        assertEquals(days1, schedule.getDays());
        assertEquals(hours1, schedule.getHourBlock());
        assertEquals(duration1, schedule.getDuration());
    }

    @Test(expected = IllegalArgumentException.class)
    public void scheduleParameterizedConstructor2Duration() {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 0;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);

        assertNotNull(schedule);
    }

    @Test
    public void setterTests() throws Exception {
        Building building1 = new Building("House of Cats");
        Building building2 = new Building("House of Dogs");
        Room room1 = new Room(256, 255, building1);
        Room room2 = new Room(258, 260, building2);
        Semester semester1 = new Semester();
        Semester semester2 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        semester2.setSemesterStartDate(2029, 8, 17);
        int duration1 = 2;
        int duration2 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        List<Days.Day> days2 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.TUESDAY, Days.Day.THURSDAY }));

        HourBlock hours1 = new HourBlock();
        HourBlock hours2 = new HourBlock();
        String hours3 = "3";
        String startDate1 = "2020/03/27";
        String startDate2 = "2029/08/17";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);
        schedule.setDays(days2);
        schedule.setBuilding(building2);
        schedule.setRoom(room2);
        schedule.setSemester(semester2);
        schedule.setDuration(duration2);
        schedule.setStartDate(startDate2);
        schedule.setId("5959");
        schedule.setHours(hours3);
        schedule.setHourBlock(hours2);

        assertNotNull(schedule);
        assertEquals(building2, schedule.getBuilding());
        assertEquals(room2, schedule.getRoom());
        assertEquals(semester2, schedule.getSemester());
        assertEquals(startDate2, schedule.getStartDate());
        assertEquals(days2, schedule.getDays());
        assertEquals(hours2.toString(), schedule.getHourBlock().toString());
        assertEquals(duration2, schedule.getDuration());
        assertEquals(hours3, schedule.getHours());
        assertEquals("5959", schedule.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNullRoom() throws Exception {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);
        schedule.setRoom(null);
        System.out.println(schedule.getRoom());

        assertNotNull(schedule);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNullBuilding() throws Exception {

        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);
        schedule.setBuilding(null);
        System.out.println(schedule.getBuilding());

        assertNotNull(schedule);
    }

    @Test
    public void setScheduleName() throws Exception {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);
        schedule.setScheduleName("Awesome Schedule");

        assertNotNull(schedule);
        assertEquals("Awesome Schedule", schedule.getScheduleName());

    }

    @Test(expected = IllegalArgumentException.class)
    public void setScheduleNameNull() throws Exception {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);
        schedule.setScheduleName(null);

        assertNotNull(schedule);
    }

    @Test
    public void toStringTest() throws Exception {
        Building building1 = new Building("House of Cats");
        Room room1 = new Room(256, 255, building1);
        Semester semester1 = new Semester();
        semester1.setSemesterStartDate(2019, 6, 15);
        int duration1 = 2;
        List<Days.Day> days1 = new ArrayList<>(Arrays.asList(
                new Days.Day[] {Days.Day.MONDAY, Days.Day.WEDNESDAY }));
        HourBlock hours1 = new HourBlock();
        hours1.setId("6363");
        String startDate1 = "2020/03/27";

        Schedule schedule = new Schedule(room1, building1, semester1,
                startDate1, duration1, days1, hours1);
        schedule.setId("5959");

        String expected = "Schedule{id: 5959, room: 256, building: House of Cats, semester: Summer, 2019, "
                + "startDate: 2020/03/27, duration: 2, days: [Monday, Wednesday], hours: null, "
                + "hourBlock: HourBlock{id = 6363, startTime = 6, duration = 1}}";

        assertEquals(expected, schedule.toString());
    }

}
