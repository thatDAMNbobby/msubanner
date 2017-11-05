package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The Course service.
 */
@Service
public class CourseService {

    /** The Course repository. */
    @Autowired
    private CourseRepository courseRepository;

    /**
     * Gets the list of all Courses.
     * @return the list of all Courses
     */
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * Gets a Course by id.
     * @param id the Course id
     * @return the Course
     */
    public Course getCourse(final String id) {
        return courseRepository.findOne(id);
    }

    /**
     * Adds a Course.
     * @param course the Course to add
     */
    public void addCourse(final Course course) {
        courseRepository.save(course);
    }

    /**
     * Updates a Course.
     * @param course the Course to update
     */
    public void updateCourse(final Course course) {
        courseRepository.save(course);
    }

    /**
     * Deletes a Course.
     * @param id the Course id
     */
    public void deleteCourse(final String id) {
        courseRepository.delete(id);
    }
}
