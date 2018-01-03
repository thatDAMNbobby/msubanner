package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.Enrollment;
import edu.msudenver.cs3250.group6.msubanner.entities.Section;
import edu.msudenver.cs3250.group6.msubanner.entities.Student;
import edu.msudenver.cs3250.group6.msubanner.repositories.SectionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrollmentControllerTest {

    @Autowired
    public EnrollmentController controller;

    @Autowired
    public SectionController sectionController;

    public SectionRepository sectionRepository;


    @Test
    public void getAllEnrollments() throws Exception {
        ModelAndView mav = controller.getAllEnrollments();
        assertThat("enrollment".equals(mav));
    }

    @Test
    public void getEnrollment() throws Exception {
    }

    @Test
    public void addEnrollment() throws Exception {
    }

    @Test
    public void deleteEnrollment() throws Exception {
    }

    @Test
    public void addEnrollmentForm() throws Exception {
        ModelAndView mav = controller.addEnrollmentForm();
        assertThat("addenrollmentform".equals(mav));
    }

}