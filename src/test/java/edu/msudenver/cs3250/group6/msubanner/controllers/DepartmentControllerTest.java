package edu.msudenver.cs3250.group6.msubanner.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import edu.msudenver.cs3250.group6.msubanner.repositories.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentControllerTest {

    @Autowired
    private DepartmentController controller;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllDepartments() throws Exception {
        ModelAndView ret = controller.getAllDepartments();
        assertThat("departments".equals(ret));
    }

    @Test
    public void testGetDepartmentById() throws Exception {
        Department  someDepartment = new Department("Marine Mammals");
        someDepartment.setId("9696");
        departmentRepository.save(someDepartment);

        ModelAndView mav = controller.getDepartment("9696");
        assertThat("showdepartment".equals(mav));
    }

    @Test
    public void testAddDepartment() throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put("9696", "Marine Mammals");

        ModelAndView mav = controller.addDepartment(body);

        assertThat("showdepartment".equals(mav));
    }

    @Test
    public void testUpdateDepartment() throws Exception {
        Department  someDepartment = new Department("Marine Mammals");
        someDepartment.setId("9696");
        departmentRepository.save(someDepartment);

        String someDepartmentName = "Marinated Mammals";

        ModelAndView mav = controller.updateDepartment(someDepartmentName, "9696");

        assertThat(mav.getViewName().equals("showdepartment"));
    }

    @Test
    public void testDeleteDepartment() throws Exception {
        Department  someDepartment = new Department("Marine Mammals");
        someDepartment.setId("9696");
        departmentRepository.save(someDepartment);

        ModelAndView mav = controller.deleteDepartment("9696");
        assertThat("department".equals(mav));
    }

    @Test
    public void editDepartment() throws Exception {
        Department  someDepartment = new Department("Marine Mammals");
        someDepartment.setId("9696");
        departmentRepository.save(someDepartment);

        ModelAndView mav = controller.editDepartment("9696");
        assertThat("department".equals(mav));
    }

    @Test
    public void testAddDepartmentForm() throws Exception {
        ModelAndView mav = controller.addDepartmentForm();
        assertThat("adddepartmentform".equals(mav));
    }
}
