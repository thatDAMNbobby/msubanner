package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Semester;

/**
 * Repository for the Semester class.
 */
@RepositoryRestResource
public interface SemesterRepository extends MongoRepository<Semester, String> {
    /**
     * Finds a semester by id.
     *
     * @param id the semester id
     * @return the semester
     */
    Semester findById(String id);

    /**
     * Finds all semesters.
     *
     * @return the list of semesters
     */
    List<Semester> findAll();
}
