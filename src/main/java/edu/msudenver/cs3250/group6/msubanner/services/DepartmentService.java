package edu.msudenver.cs3250.group6.msubanner.services;


import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Department service.
 */
@Service
public class DepartmentService {

    /** The department repository. */
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Gets the list of all departments.
     * @return the list of all departments
     */
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Gets a course by id.
     * @param id the department id
     * @return the department
     */
    public Department getDepartment(final String id) {
        return departmentRepository.findOne(id);
    }

    /**
     * Adds a department.
     * @param department the department to add
     */
    public void addDepartment(final Department department) {
        departmentRepository.save(department);
    }

    /**
     * Updates a department.
     * @param department the department to update
     */
    public void updateDepartment(final Department department) {
        departmentRepository.save(department);
    }

    /**
     * Deletes a department.
     * @param id the department id
     */
    public void deleteDepartment(final String id) {
        departmentRepository.delete(id);
    }
}
