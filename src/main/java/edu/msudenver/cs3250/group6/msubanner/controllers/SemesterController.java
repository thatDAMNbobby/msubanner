package edu.msudenver.cs3250.group6.msubanner.controllers;


import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for the Semester class
 */
@Controller
public class SemesterController {

    /** The Semester service. */
    @Autowired
    private SemesterService semesterService;

    /**
     * Gets the list of all Semesters.
     *
     * @return the list of all semesters
     */
    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public ModelAndView getAllSemesters() {
        ModelAndView mav = new ModelAndView("semesters");
        mav.addObject("allsemesters", semesterService.getAllSemesters());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
