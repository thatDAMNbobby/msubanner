package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Repository for department class.
 */
@RepositoryRestResource
@Persistent
public interface DepartmentRepository extends MongoRepository<Department, String> {
    public Department findById(String id);
    public List<Department> findAll();
}
