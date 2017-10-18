package edu.msudenver.cs3250.group6.msubanner.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * The controller for the course class.
 */
@Controller
public class CourseController {

    /** The course service. */
    @Autowired
    private CourseService courseService;

    /**
     * Gets the list of all courses.
     * @return the list of all courses
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getAllCourses() {
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a course by id number.
     * @param id the course id
     * @return the course
     */
    @RequestMapping("/courses/{id}")
    public ModelAndView getCourse(@PathVariable final long id) {
        ModelAndView mav = new ModelAndView("showcourse");
        mav.addObject("course", courseService.getCourse(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a course.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/courses/addcourse")
    public ModelAndView addCourse(@RequestParam final String courseTitle, String courseDescription,
                                  int courseCredits, String courseLearningObjectives, ClassLevel coursePrereqs) {
        Course course = new Course(courseTitle, courseDescription, courseCredits,
                courseLearningObjectives, coursePrereqs);
        courseService.addCourse(course);
        ModelAndView mav = new ModelAndView("showcourse");
        mav.addObject("course", course);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a course.
     * @param course the course to be updated
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/courses/updatecourse/{id}")
    public ModelAndView updateCourse(@RequestParam final Course course,
                              @PathVariable final long id) {
        courseService.updateCourse(course);
        ModelAndView mav = new ModelAndView("showcourse");
        mav.addObject("course", course);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a course.
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/courses/deletecourse/{id}")
    public ModelAndView deleteCourse(@PathVariable final long id) {
        courseService.deleteCourse(id);
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    @RequestMapping("/courses/editcourse/{id}")
    public ModelAndView editCourse(@PathVariable final long id) {
        ModelAndView mav = new ModelAndView("editcourseform");
        mav.addObject("course", courseService.getCourse(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
