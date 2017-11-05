package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Repository for the Semester class.
 */
@RepositoryRestResource
public interface SemesterRepository extends MongoRepository<Semester, String> {
    public Semester findById(String id);
    public List<Semester> findAll();
}
