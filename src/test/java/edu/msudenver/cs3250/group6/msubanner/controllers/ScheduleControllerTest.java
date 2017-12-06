package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Days;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;
import edu.msudenver.cs3250.group6.msubanner.services.ScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleControllerTest {

    @Autowired
    public ScheduleController controller;

    @Autowired
    public ScheduleService service;

    @Test
    public void getAllSchedules() throws Exception {
        ModelAndView mav = controller.getAllSchedules();
        assertThat("schedules".equals(mav));
    }

    @Test
    public void addSchedule() throws Exception {
        Building building = new Building("Citadel");
        building.setId("99");
        Room room = new Room(1,1,building);
        room.setId("98");
        Schedule s = service.getSchedule("4512");
        ModelAndView mav = controller.addSchedule(room, building, s.getSemester(),
                s.getStartDate(),2,"MW",6,2);
        assertThat("schedules".equals(mav));
    }

    @Test
    public void getSchedule() throws Exception {
        ModelAndView mav = controller.getSchedule("4512");
        assertThat("schedule".equals(mav));
    }

    @Test
    public void editSchedule() throws Exception {
        List<Schedule> s = service.getAllSchedules();
        Schedule sc = s.get(0);
        ModelAndView mav = controller.editSchedule(sc.getId());
        assertThat(true);
    }

    @Test
    public void updateSection() throws Exception {
        Building building = new Building("Citadel");
        building.setId("97");
        Room room = new Room(1,5,building);
        room.setId("96");
        List<Schedule> sc = service.getAllSchedules();
        Schedule s = sc.get(0);
        ModelAndView mav = controller.updateSection(building, room, s.getSemester(),
                s.getStartDate(),2, (ArrayList<Days.Day>) s.getDays(),8,2, "4512");

        assertThat("showschedule".equals(mav));
    }

    @Test
    public void deleteSchedule() throws Exception {
        assertThat("redirect:/schedules".equals(controller.deleteSchedule("4512")));
    }

    @Test
    public void addScheduleForm() throws Exception {
        ModelAndView mav = controller.addScheduleForm();
        assertThat("addscheduleform".equals(mav));
    }

}