package edu.msudenver.cs3250.group6.msubanner.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.services.DepartmentService;

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
     *
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
     *
     * @param id the department id
     * @return the department
     */
    @RequestMapping("/departments/{id}")
    public ModelAndView getDepartment(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showdepartment");
        mav.addObject("department", departmentService.getDepartment(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a department.
     *
     * @param body the department info
     * @return the department
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/departments/adddepartment")
    public ModelAndView addDepartment(
            @RequestParam final Map<String, String> body) {
        System.out.println(
                "Post request hit /departments/adddepartment containing "
                        + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        Department dept = new Department();
        String deptName = body.get("departmentName");

        dept.setDepartmentName(deptName);

        departmentService.addDepartment(dept);

        ModelAndView mav = new ModelAndView("showdepartment");
        mav.addObject("department", dept);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a department.
     *
     * @param departmentName the department name
     * @param id the department's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/departments/updatedepartment/{id}")
    public ModelAndView updateDepartment(
            @RequestParam final String departmentName,
            @PathVariable final String id) {
        Department department = departmentService.getDepartment(id);
        department.setDepartmentName(departmentName);
        departmentService.updateDepartment(department);
        ModelAndView mav = new ModelAndView("showdepartment");
        mav.addObject("department", departmentService.getDepartment(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a department.
     *
     * @param id the department's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/departments/deletedepartment/{id}")
    public ModelAndView deleteDepartment(@PathVariable final String id) {
        departmentService.deleteDepartment(id);
        ModelAndView mav = new ModelAndView("departments");
        mav.addObject("alldepartments", departmentService.getAllDepartments());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Edits a department.
     *
     * @param id the department id
     * @return the model and view
     */
    @RequestMapping("/departments/editdepartment/{id}")
    public ModelAndView editDepartment(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editdepartmentform");
        mav.addObject("department", departmentService.getDepartment(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add department form.
     *
     * @return the add department form string
     */
    @RequestMapping("/departments/adddepartment")
    ModelAndView addDepartmentForm() {
        ModelAndView mav = new ModelAndView("adddepartmentform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
