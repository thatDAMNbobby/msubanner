package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.*;
import edu.msudenver.cs3250.group6.msubanner.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EnrollmentController {

    /** The Enrollment service. */
    @Autowired
    private EnrollmentService enrollmentService;

    /** The Student service. */
    @Autowired
    private StudentService studentService;

    /**The section service*/
    @Autowired
    private SectionService sectionService;


    /**
     * Gets the list of all Enrollments.
     *
     * @return the list of all Enrollments
     */
    @RequestMapping(value = "/enrollments", method = RequestMethod.GET)
    public ModelAndView getAllEnrollments() {
        ModelAndView mav = new ModelAndView("enrollment");
        mav.addObject("allenrollments", enrollmentService.getAllEnrollments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a Enrollment by id number.
     *
     * @param id the enrollment id
     * @return the enrollment
     */
    @RequestMapping("/enrollments/{id}")
    public ModelAndView getEnrollment(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showenrollment");
        Student student = studentService.getStudent(id);
        Section section = sectionService.getSection(id);

        mav.addObject("student", student);
        mav.addObject("section", section);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds an enrollment.
     *
     * @param student the students name
     * @param section the class section
     * @return the enrollment
     */
    @RequestMapping(method = RequestMethod.POST, value = "/enrollments/addenrollment")
    public ModelAndView addEnrollment(@RequestParam final Student student, final Section section) throws Exception {

        Enrollment enrollment = new Enrollment(student,section);

        enrollmentService.addEnrollment(enrollment);

        ModelAndView mav = new ModelAndView("enrollment");
        mav.addObject("allenrollments", enrollmentService.getAllEnrollments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes an enrollment.
     *
     * @param id the Enrollments's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/enrollments/deleteenrollment/{id}")
    public ModelAndView deleteEnrollment(@PathVariable final String id) {
        enrollmentService.deleteEnrollment(id);
        ModelAndView mav = new ModelAndView("enrollment");
        mav.addObject("allenrollments", enrollmentService.getAllEnrollments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add enrollment form.
     *
     * @return ModelAndView redirecting to the form
     */
    @RequestMapping("/enrollments/addenrollment")
    ModelAndView addEnrollmentForm() {
        ModelAndView mav = new ModelAndView("addenrollmentform");
        mav.addObject("allstudents", studentService.getAllStudents());
        mav.addObject("allsections", sectionService.getAllSections());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
