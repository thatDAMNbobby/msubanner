package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.*;
import edu.msudenver.cs3250.group6.msubanner.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private HourBlockService hourBlockService;

    @Autowired
    private SemesterService semesterService;

    @RequestMapping("/schedules")
    public ModelAndView getAllSchedules() {
        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/schedules/addschedule")
    public ModelAndView addSchedule(@RequestParam final Room room, @RequestParam final Building building,
                                    Semester semester, String startDate, int duration, String days,
                                    //String hours
                                    int hourBlockStartTime, int hourBlockDuration
                                    ) {
        //Schedule schedule = new Schedule(room, building, semester, startDate, duration, days, hours);

        HourBlock block = new HourBlock(hourBlockStartTime, hourBlockDuration);
        hourBlockService.addHourBlock(block);

        Schedule schedule = new Schedule(room, building, semester, startDate, duration, days, block);
        scheduleService.addSchedule(schedule);


        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        mav.addObject("allsemesters", semesterService.getAllSemesters());


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
     * Updates a schedule.
     *
     * @param id the schedule's id
     **/
    @RequestMapping(method = RequestMethod.GET,
            value = "/schedules/updateschedule/{id}")
    public ModelAndView updateSection(@RequestParam final Building building, final Room room, final Semester semester,
                                      final String startDate, final int duration, final String days,
                                      //final String hours ,
                                      int hourBlockStartTime, int hourBlockDuration,
                                      @PathVariable final String id) {

        Schedule schedule = scheduleService.getSchedule(id);
        schedule.setBuilding(building);
        schedule.setRoom(room);
        schedule.setDuration(duration);
        schedule.setDays(days);
        //schedule.setHours(hours);
        HourBlock oldBlock = schedule.getHourBlock();
        hourBlockService.deleteHourBlock(oldBlock.getId());

        HourBlock newBlock = new HourBlock(hourBlockStartTime, hourBlockDuration);
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
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/schedules/deleteschedule/{id}")
    public String deleteSchedule(@PathVariable final String id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules/";
    }

    /**
     * Maps to the edit schedule form.
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
