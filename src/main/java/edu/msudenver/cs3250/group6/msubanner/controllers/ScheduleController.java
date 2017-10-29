package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;
import edu.msudenver.cs3250.group6.msubanner.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/schedules")
    public ModelAndView getAllSchedules() {
        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/schedules/addschedule")
    public ModelAndView addSchedule(@RequestParam final Room room, @RequestParam final Building building, String semester, String startDate, int duration, String days, String hours) {
        Schedule schedule = new Schedule(room, building, semester, startDate, duration, days, hours);
        scheduleService.addSchedule(schedule);

        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());

        return mav;
    }



}
