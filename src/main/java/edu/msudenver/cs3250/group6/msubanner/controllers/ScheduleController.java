package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Days;
import edu.msudenver.cs3250.group6.msubanner.entities.HourBlock;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;
import edu.msudenver.cs3250.group6.msubanner.services.HourBlockService;
import edu.msudenver.cs3250.group6.msubanner.services.ScheduleService;
import edu.msudenver.cs3250.group6.msubanner.entities.Semester;

/**
 * The schedule controller.
 */
@Controller
public class ScheduleController {

    /** The schedule service. */
    @Autowired
    private ScheduleService scheduleService;

    /** The hour block service. */
    @Autowired
    private HourBlockService hourBlockService;

    /**
     * Gets all schedules.
     *
     * @return the model and view
     */
    @RequestMapping("/schedules")
    public ModelAndView getAllSchedules() {
        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a schedule.
     *
     * @param room the room
     * @param building the building
     * @param semester the semester
     * @param startDate the start date
     * @param duration the duration
     * @param days the days
     * @param hourBlockStartTime the start time
     * @param hourBlockDuration the duration
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/schedules/addschedule")
    public ModelAndView addSchedule(@RequestParam final Room room,
            @RequestParam final Building building, final String semester,
            final String startDate, final int duration, final Days days,
            final int hourBlockStartTime, final int hourBlockDuration) {
        HourBlock block = new HourBlock(hourBlockStartTime, hourBlockDuration);
        hourBlockService.addHourBlock(block);

        Schedule schedule = new Schedule(room, building, semester, startDate,
                duration, days, block);
        scheduleService.addSchedule(schedule);

        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());

        return mav;
    }

    /**
     * Gets a schedule by id number.
     *
     * @param id the schedule id
     * @return the schedule
     */
    @RequestMapping("/schedules/getschedule/{id}")
    public ModelAndView getSchedule(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showschedule");
        mav.addObject("schedule", scheduleService.getSchedule(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a section.
     *
     * @param building the building
     * @param room the room
     * @param semester the semester
     * @param startDate the start date
     * @param duration the duration
     * @param days the days
     * @param hourBlockStartTime the start time
     * @param hourBlockDuration the duration
     * @param id the section id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/schedules/updateschedule/{id}")
    public ModelAndView updateSection(@RequestParam final Building building,
            final Room room, final Semester semester, final String startDate,
            final int duration, final Days days, final int hourBlockStartTime,
            final int hourBlockDuration, @PathVariable final String id) {

        Schedule schedule = scheduleService.getSchedule(id);
        schedule.setBuilding(building);
        schedule.setRoom(room);
        schedule.setDuration(duration);
        schedule.setDays(days);
        // schedule.setHours(hours);
        HourBlock oldBlock = schedule.getHourBlock();
        hourBlockService.deleteHourBlock(oldBlock.getId());

        HourBlock newBlock = new HourBlock(hourBlockStartTime,
                hourBlockDuration);
        hourBlockService.addHourBlock(newBlock);
        schedule.setHourBlock(newBlock);

        schedule.setSemester(semester);
        schedule.setStartDate(startDate);
        scheduleService.updateSchedule(schedule);

        ModelAndView mav = new ModelAndView("showschedule");
        mav.addObject("schedule", scheduleService.getSchedule(id));
        mav.addObject("room", room);
        mav.addObject("building", building);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a section.
     *
     * @param id the schedule's id
     * @return a redirect string
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/schedules/deleteschedule/{id}")
    public String deleteSchedule(@PathVariable final String id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules/";
    }

    /**
     * Maps to the edit schedule form.
     *
     * @param id the id of the schedule
     * @return ModelAndView containing the selected schedule
     */
    @RequestMapping("/schedules/editschedule/{id}")
    public ModelAndView editSchedule(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editscheduleform");
        Schedule schedule = scheduleService.getSchedule(id);
        Room room = schedule.getRoom();
        Building building = schedule.getBuilding();
        mav.addObject("schedule", scheduleService.getSchedule(id));
        mav.addObject("room", room);
        mav.addObject("building", building);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
