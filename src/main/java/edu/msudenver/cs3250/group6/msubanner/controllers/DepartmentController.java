package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Controller for the department class.
 */
@Controller
public class DepartmentController {

    /** The department service. */
    @Autowired
    private DepartmentService departmentService;

    /**
     * Gets the list of all departments.
     * @return the list of all departments
     */
    @RequestMapping("/departments")
    public ModelAndView getAllDepartments() {
        ModelAndView mav = new ModelAndView("departments");
        mav.addObject("alldepartments", departmentService.getAllDepartments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a department by id number.
     * @param id the department id
     * @return the department
     */
    @RequestMapping("/departments/{id}")
    public ModelAndView getDepartment(@PathVariable final long id) {
        ModelAndView mav = new ModelAndView("showdepartment");
        mav.addObject("department", departmentService.getDepartment(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a department.
     * @param department the course to be added
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/departments/adddepartment")
    public ModelAndView addDepartment(@RequestParam final Map<String, String> body) {
        ModelAndView mav = new ModelAndView("showdepartment");
        System.out.println("Post request hit /departments/adddepartment containing " + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        Department dept = new Department();
        String deptName = body.get("departmentName");

        dept.setDepartmentName(deptName);

        departmentService.addDepartment(dept);
        mav.addObject("department", dept);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a department.
     * @param department the department to be updated
     * @param id the department's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/departments/updatedepartment/{id}")
    public void updateDepartment(@RequestBody final Department department,
            @PathVariable final long id) {
        departmentService.updateDepartment(department);
    }

    /**
     * Deletes a department.
     * @param id the department's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/departments/deletedepartment/{id}")
    public ModelAndView deleteDepartment(@PathVariable final long id) {
        departmentService.deleteDepartment(id);
        ModelAndView mav = new ModelAndView("departments");
        mav.addObject("alldepartments", departmentService.getAllDepartments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
