package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository for department class.
 */
@RepositoryRestResource
@Persistent
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
