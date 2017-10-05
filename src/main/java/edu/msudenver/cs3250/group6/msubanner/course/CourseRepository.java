package edu.msudenver.cs3250.group6.msubanner.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository for the course class.
 */
@RepositoryRestResource
public interface CourseRepository extends CrudRepository<Course, Long> {
}
