package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The course service.
 */
@Service
public class CourseService {

    /** The course repository. */
    @Autowired
    private CourseRepository courseRepository;

    /**
     * Gets the list of all courses.
     * @return the list of all courses
     */
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * Gets a course by id.
     * @param id the course id
     * @return the course
     */
    public Course getCourse(final String id) {
        return courseRepository.findOne(id);
    }

    /**
     * Adds a course.
     * @param course the course to add
     */
    public void addCourse(final Course course) {
        courseRepository.save(course);
    }

    /**
     * Updates a course.
     * @param course the course to update
     */
    public void updateCourse(final Course course) {
        courseRepository.save(course);
    }

    /**
     * Deletes a course.
     * @param id the course id
     */
    public void deleteCourse(final String id) {
        courseRepository.delete(id);
    }
}
