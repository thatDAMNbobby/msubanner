package edu.msudenver.cs3250.group6.msubanner.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentControllerTest {

    @Autowired
    private DepartmentController controller;

    @Autowired
    CourseRepository departmentRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAllDepartments() throws Exception {
    }

    @Test
    public void getDepartment() throws Exception {
    }

    @Test
    public void addDepartment() throws Exception {
    }

    @Test
    public void updateDepartment() throws Exception {
    }

    @Test
    public void deleteDepartment() throws Exception {
    }

    @Test
    public void editDepartment() throws Exception {
    }

}