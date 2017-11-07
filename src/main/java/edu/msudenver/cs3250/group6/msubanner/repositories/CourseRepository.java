package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Course;

/**
 * Repository for the Course class.
 */
@RepositoryRestResource
public interface CourseRepository extends MongoRepository<Course, String> {
    /**
     * Finds a course by id.
     *
     * @param id the course id
     * @return the course
     */
    Course findById(String id);

    /**
     * Finds all courses.
     *
     * @return the list of courses
     */
    List<Course> findAll();
}
