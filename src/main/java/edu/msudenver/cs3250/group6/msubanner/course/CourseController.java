package edu.msudenver.cs3250.group6.msubanner.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The controller for the course class.
 */
@RestController
public class CourseController {

    /** The course service. */
    @Autowired
    private CourseService courseService;

    /**
     * Gets the list of all courses.
     * @return the list of all courses
     */
    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    /**
     * Gets a course by id number.
     * @param id the course id
     * @return the course
     */
    @RequestMapping("/courses/getcourse/{id}")
    // @PathVariable indicates use of {id} wildcard above
    public Course getCourse(@PathVariable final long id) {
        return courseService.getCourse(id);
    }

    /**
     * Adds a course.
     * @param course the course to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/courses/addcourse")
    // take request body, turn into Course instance and pass to addCourse()
    public void addCourse(@RequestBody final Course course) {
        // POST body should contain object being sent
        courseService.addCourse(course);
    }

    /**
     * Updates a course.
     * @param course the course to be updated
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/courses/updatecourse/{id}")
    // take request body, turn into Course instance and pass to addCourse()
    public void updateCourse(@RequestBody final Course course,
                              @PathVariable final long id) {
        // POST body should contain object being sent
        courseService.updateCourse(course);
    }

    /**
     * Deletes a course.
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/courses/deletecourse/{id}")
    public void deleteCourse(@PathVariable final long id) {
        // @PathVariable indicates use of wildcard above
        courseService.deleteCourse(id);
    }
}