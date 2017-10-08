package edu.msudenver.cs3250.group6.msubanner.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller for the department class.
 */
@RestController
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
    public ResponseEntity<Department> addDepartment(@RequestParam final Map<String, String> body) {
        // POST body should contain object being sent
        //departmentService.addDepartment(department);

        System.out.println("Post request hit /departments/adddepartment containing " + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        Department dept = new Department();
        String deptName = body.get("departmentName");

        dept.setDepartmentName(deptName);

        departmentService.addDepartment(dept);
        return new ResponseEntity<Department>(dept, HttpStatus.CREATED);
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
