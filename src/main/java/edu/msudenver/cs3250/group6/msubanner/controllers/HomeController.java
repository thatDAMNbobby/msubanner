package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Days;
import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import edu.msudenver.cs3250.group6.msubanner.services.RoomService;
import edu.msudenver.cs3250.group6.msubanner.services.SemesterService;

/*
 *  The purpose here is to get a mapping to the index.html in templates
 *  from: https://spring.io/blog/2016/11/21
 *          /the-joy-of-mustache-server-side-templates-for-the-jvm
 *        https://springframework.guru
 *          /spring-boot-web-application-part-2-using-thymeleaf/
 */

/**
 * Controller for mapping to index.html home page.
 */
@Controller
class HomeController {

    /** The building repository. */
    @Autowired
    private BuildingService buildingService;

    /** The room service. */
    @Autowired
    private RoomService roomService;

    /** The semester service. */
    @Autowired
    private SemesterService semesterService;

    /**
     * Maps the home page to index.html.
     *
     * @return the index string
     */
    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add department form.
     *
     * @return the add department form string
     */
    @RequestMapping("/departments/adddepartment")
    ModelAndView addDepartmentForm() {
        ModelAndView mav = new ModelAndView("adddepartmentform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add section form.
     *
     * @return the add section form string
     */
    @RequestMapping("schedules/addschedule")
    ModelAndView addScheduleForm() {
        ModelAndView mav = new ModelAndView("addscheduleform");
        mav.addObject("allrooms", roomService.getAllRooms());
        mav.addObject("allbuildings", buildingService.getAllBuildings());
        mav.addObject("allsemesters", semesterService.getAllSemesters());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        mav.addObject("alldays", Days.Day.values());
        return mav;
    }
}
