package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.SemesterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SemesterControllerTest {

    @Autowired
    private SemesterController controller;

    @Autowired
    SemesterRepository semesterRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllSemesters() throws Exception {
        ModelAndView ret = controller.getAllSemesters();
        assertThat("users".equals(ret));
    }

    @Test
    public void testGetSemesterById() throws Exception {
        Semester semester = new Semester();

        semester.setId("554");
        semesterRepository.save(semester);

        ModelAndView mav = controller.getSemester("554");
        assertThat("semester".equals(mav));
    }

    @Test
    public void testAddSemester() throws Exception {
        int someStartYear = 2024;
        int someStartMonth = 1;
        int someStartDay = 12;
        int someEndYear = 2025;
        int someEndMonth = 3;
        int someEndDay = 12;
        String someSeason = "SPRING";

        ModelAndView mav = controller.addSemester(someStartYear,someStartMonth, someStartDay, someEndYear, someEndMonth, someEndDay, someSeason);
        assertThat("showsemester".equals(mav));
    }

    @Test
    public void updateSemester() throws Exception {
        Semester semester = new Semester();

        semester.setId("554");
        semesterRepository.save(semester);

        int someStartYear = 2024;
        int someStartMonth = 1;
        int someStartDay = 12;
        int someEndYear = 2025;
        int someEndMonth = 3;
        int someEndDay = 12;
        String someSeason = "SPRING";

        ModelAndView mav = controller.updateSemester(someStartYear,someStartMonth, someStartDay, someEndYear, someEndMonth, someEndDay, someSeason, "554");
        assertThat("showsemester".equals(mav));
    }

    @Test
    public void deleteSemester() throws Exception {
    }

    @Test
    public void editCourse() throws Exception {
    }

    @Test
    public void addSemesterForm() throws Exception {
    }

}