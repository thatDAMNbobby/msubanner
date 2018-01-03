package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import edu.msudenver.cs3250.group6.msubanner.services.SemesterService;

/**
 * The controller for the Semester class.
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

    /**
     * Adds a Semester.
     *
     * @param startYear the year the semester starts
     * @param startMonth the month the semester starts
     * @param startDay the day the semester starts
     * @param endYear the year the semester ends
     * @param endMonth the month the semester ends
     * @param endDay the day the semester ends
     * @param season the season the semester is in (Fall, Spring, Summer)
     * @return ModelAndView of the semester
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/semesters/addsemester")
    public ModelAndView addSemester(@RequestParam final int startYear,
            final int startMonth, final int startDay, final int endYear,
            final int endMonth, final int endDay, final String season) {
        Semester semester = new Semester();
        semester.setSemesterStartDate(startYear, startMonth, startDay);
        semester.setSemesterEndDate(endYear, endMonth, endDay);
        semester.setSeason(season);
        semesterService.addSemester(semester);

        ModelAndView mav = new ModelAndView("showsemester");
        mav.addObject("semester", semester);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a Semester.
     *
     * @param startYear the year the semester starts
     * @param startMonth the month the semester starts
     * @param startDay the day the semester starts
     * @param endYear the year the semester ends
     * @param endMonth the month the semester ends
     * @param endDay the day the semester ends
     * @param season the season the semester is in (Fall, Spring, Summer)
     * @param id the semester id
     * @return ModelAndView of the semester
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/semesters/updatesemester/{id}")
    public ModelAndView updateSemester(@RequestParam final int startYear,
            final int startMonth, final int startDay, final int endYear,
            final int endMonth, final int endDay, final String season,
            @PathVariable final String id) {
        Semester semester = semesterService.getSemester(id);
        semester.setSemesterStartDate(startYear, startMonth, startDay);
        semester.setSemesterEndDate(endYear, endMonth, endDay);
        semester.setSeason(season);
        semesterService.addSemester(semester);

        ModelAndView mav = new ModelAndView("showsemester");
        mav.addObject("semester", semester);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a Semester.
     *
     * @param id the semester's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/semesters/deletesemester/{id}")
    public ModelAndView deleteSemester(@PathVariable final String id) {
        semesterService.deleteSemester(id);
        ModelAndView mav = new ModelAndView("semesters");
        mav.addObject("allsemesters", semesterService.getAllSemesters());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the edit course form.
     *
     * @param id id of the selected course
     * @return ModelAndView containing the selected course
     */
    @RequestMapping("/semesters/editsemester/{id}")
    public ModelAndView editCourse(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editsemesterform");
        mav.addObject("semester", semesterService.getSemester(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add semester form.
     *
     * @return ModelAndView redirecting to the form
     */
    @RequestMapping("/semesters/addsemester")
    ModelAndView addSemesterForm() {
        ModelAndView mav = new ModelAndView("addsemesterform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
