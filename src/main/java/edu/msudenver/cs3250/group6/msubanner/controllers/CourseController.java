package edu.msudenver.cs3250.group6.msubanner.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.services.CourseService;
import edu.msudenver.cs3250.group6.msubanner.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.services.CourseService;

/**
 * The controller for the Course class.
 */
@Controller
public class CourseController {

    /** The Course service. */
    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * Gets the list of all Courses.
     *
     * @return the list of all Courses
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getAllCourses() {
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a Course by id number.
     *
     * @param id the course id
     * @return the course
     */
    @RequestMapping("/courses/{id}")
    public ModelAndView getCourse(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showcourse");
        Course course = courseService.getCourse(id);

        mav.addObject("course", course);
        mav.addObject("department", course.getDepartment());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a course.
     *
     * @param courseTitle the course title
     * @param courseDescription the course description
     * @param courseCredits the course credits
     * @param courseLearningObjectives the course learning objectives
     * @param coursePrereqs the course prereqs
     * @return the course
     */
    @RequestMapping(method = RequestMethod.POST, value = "/courses/addcourse")
    public ModelAndView addCourse(@RequestParam final String courseTitle, String courseDescription,
                                  int courseCredits, String courseLearningObjectives,
                                  ClassLevel coursePrereqs, Department courseDepartment) {

        Course course = new Course(courseTitle, courseDescription, courseCredits,
                courseLearningObjectives, coursePrereqs, courseDepartment);
        courseService.addCourse(course);

        ModelAndView mav = new ModelAndView("showcourse");
        mav.addObject("course", course);
        mav.addObject("alldepartments", departmentService.getAllDepartments());
        mav.addObject("department", course.getDepartment());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a course.
     *
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/courses/updatecourse/{id}")
    public ModelAndView updateCourse(@RequestParam final String title, final String description,
                                     final int credits, final String learningObjectives, final ClassLevel prereqs,
                                     final Department department, @PathVariable final String id) {
        Course course = courseService.getCourse(id);
        course.setDescription(description);
        course.setTitle(title);
        course.setCredits(credits);
        course.setLearningObjectives(learningObjectives);
        course.setPrereqs(prereqs);
        course.setDepartment(department);
        courseService.updateCourse(course);
        ModelAndView mav = new ModelAndView("showcourse");
        mav.addObject("course", course);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a course.
     *
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/courses/deletecourse/{id}")
    public ModelAndView deleteCourse(@PathVariable final String id) {
        courseService.deleteCourse(id);
        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the edit course form.
     *
     * @param id id of the selected course
     * @return ModelAndView containing the selected course
     */
    @RequestMapping("/courses/editcourse/{id}")
    public ModelAndView editCourse(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editcourseform");
        mav.addObject("alldepartments", departmentService.getAllDepartments());
        mav.addObject("course", courseService.getCourse(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add course form.
     *
     * @return ModelAndView redirecting to the form
     */
    @RequestMapping("/courses/addcourse")
    ModelAndView addCourseForm() {
        ModelAndView mav = new ModelAndView("addcourseform");
        mav.addObject("prereqs", ClassLevel.values());
        mav.addObject("alldepartments", departmentService.getAllDepartments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
