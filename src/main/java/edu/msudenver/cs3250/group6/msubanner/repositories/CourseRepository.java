package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Repository for the Course class.
 */
@RepositoryRestResource
public interface CourseRepository extends MongoRepository<Course, String> {
    public Course findById(String id);
    public List<Course> findAll();
}
