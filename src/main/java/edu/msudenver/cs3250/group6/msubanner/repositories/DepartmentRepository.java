package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Department;

/**
 * Repository for department class.
 */
@RepositoryRestResource
@Persistent
public interface DepartmentRepository
        extends MongoRepository<Department, String> {
    /**
     * Finds a department by id.
     *
     * @param id the department id
     * @return the department
     */
    Department findById(String id);
    /**
     * Finds all departments.
     *
     * @return the list of departments
     */
    List<Department> findAll();
}
