package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {

    /**
     * Finds a enrollment by id.
     *
     * @param id the enrollment id
     * @return the enrollment
     */
    Enrollment findById(String id);

    /**
     * Finds all enrollments.
     *
     * @return the list of enrollments
     */
    List<Enrollment> findAll();


}
