package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.services.CourseService;
import edu.msudenver.cs3250.group6.msubanner.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for the Course class.
 */
@Controller
public class CourseController {

    /** The Course service. */
    @Autowired
    private CourseService courseService;

    /** The department service. */
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
     * @param courseDepartment the course department
     * @return the course
     */
    @RequestMapping(method = RequestMethod.POST, value = "/courses/addcourse")
    public ModelAndView addCourse(@RequestParam final String courseTitle,
            final String courseDescription, final int courseCredits,
            final String courseLearningObjectives,
            final ClassLevel coursePrereqs, final Department courseDepartment) {

        Course course = new Course(courseTitle, courseDescription,
                courseCredits, courseLearningObjectives, coursePrereqs,
                courseDepartment);
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
     * @param title the course title
     * @param description the course description
     * @param credits the number of credits
     * @param learningObjectives the course learning objectives
     * @param prereqs the course prerequisites
     * @param department the course department
     * @param id the course id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/courses/updatecourse/{id}")
    public ModelAndView updateCourse(@RequestParam final String title,
            final String description, final int credits,
            final String learningObjectives, final ClassLevel prereqs,
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
     * @return the model and view
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
