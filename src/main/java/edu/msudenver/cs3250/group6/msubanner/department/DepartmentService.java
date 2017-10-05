package edu.msudenver.cs3250.group6.msubanner.department;


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
        List<Department> departments = new ArrayList<>();
        // populate the department list with each element in the repository
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    /**
     * Gets a course by id.
     * @param id the department id
     * @return the department
     */
    public Department getDepartment(final long id) {
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
    public void deleteDepartment(final long id) {
        departmentRepository.delete(id);
    }
}
