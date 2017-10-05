package edu.msudenver.cs3250.group6.msubanner.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Controller for the department class.
 */
public class DepartmentController {

    /** The department service. */
    @Autowired
    private DepartmentService departmentService;

    /**
     * Gets the list of all departments.
     * @return the list of all departments
     */
    @RequestMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * Gets a department by id number.
     * @param id the department id
     * @return the department
     */
    @RequestMapping("/departments/getdepartment/{id}")
    // @PathVariable indicates use of {id} wildcard above
    public Department getDepartment(@PathVariable final long id) {
        return departmentService.getDepartment(id);
    }

    /**
     * Adds a department.
     * @param department the course to be added
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/departments/adddepartment")
    // take request body, turn into Department instance and pass to
    // addDepartment()
    public void addDepartment(@RequestBody final Department department) {
        // POST body should contain object being sent
        departmentService.addDepartment(department);
    }

    /**
     * Updates a department.
     * @param department the department to be updated
     * @param id the department's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/departments/updatedepartment/{id}")
    // take request body, turn into Department instance and pass to
    // addDepartment()
    public void updateDepartment(@RequestBody final Department department,
            @PathVariable final long id) {
        // POST body should contain object being sent
        departmentService.updateDepartment(department);
    }

    /**
     * Deletes a department.
     * @param id the department's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/departments/deletedepartment/{id}")
    public void deleteDepartment(@PathVariable final long id) {
        // @PathVariable indicates use of wildcard above
        departmentService.deleteDepartment(id);
    }
}
