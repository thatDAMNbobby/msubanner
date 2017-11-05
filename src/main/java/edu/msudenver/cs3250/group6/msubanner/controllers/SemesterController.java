package edu.msudenver.cs3250.group6.msubanner.controllers;


import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import edu.msudenver.cs3250.group6.msubanner.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @return the list of all Semesters
     */
    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public ModelAndView getAllSemesters() {
        ModelAndView mav = new ModelAndView("semesters");
        mav.addObject("allsemesters", semesterService.getAllSemesters());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a Semester by id number.
     *
     * @param id the Semester id
     * @return the semester
     */
    @RequestMapping("/semesters/{id}")
    public ModelAndView getSemester(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showsemester");
        Semester semester = semesterService.getSemester(id);

        mav.addObject("semester", semester);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
