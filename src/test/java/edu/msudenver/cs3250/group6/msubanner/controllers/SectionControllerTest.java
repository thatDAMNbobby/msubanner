package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.*;
import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.repositories.SectionRepository;
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
public class SectionControllerTest {
    @Autowired
    private SectionController controller;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllSections() throws Exception {
        ModelAndView ret = controller.getAllSections();
        assertThat("sections".equals(ret));
    }

    @Test
    public void testGetSectionById() throws Exception {
        Section section = new Section();
        section.setId("ImAnId");

        ModelAndView mav = controller.getSection("ImAnId");
        assertThat("showsection".equals(mav));
    }

    @Test
    public void addSection() throws Exception {
        Course someCourse = new Course();
        someCourse.setId("someCourseId");
        Professor someProfessor = new Professor();
        someProfessor.setId("someProfessorId");
        Schedule someSchedule = new Schedule();
        someSchedule.setId("someScheduleId");

        ModelAndView mav = controller.addSection(someCourse, someProfessor, someSchedule);

        assertThat("showsection".equals(mav));
    }

    @Test
    public void testUpdateSection() throws Exception {
        Course someCourse = new Course();
        someCourse.setId("someCourseId");
        Professor someProfessor = new Professor();
        someProfessor.setId("someProfessorId");
        Schedule someSchedule = new Schedule();
        someSchedule.setId("someScheduleId");

        Section someSection = new Section();
        someSection.setId("someSectionId");
        someSection.setSchedule(someSchedule);
        someSection.setCourse(someCourse);
        someSection.setProfessor(someProfessor);

        sectionRepository.save(someSection);

        Course someOtherCourse = new Course();
        someOtherCourse.setId("someOtherCourseId");
        Professor someOtherProfessor = new Professor();
        someOtherProfessor.setId("someOtherProfessorId");
        Schedule someOtherSchedule = new Schedule();
        someOtherSchedule.setId("someOtherScheduleId");

        ModelAndView mav = controller.updateSection(someOtherCourse, someOtherProfessor, someOtherSchedule, "someSectionId");

        assertThat(mav.getViewName().equals("showsection"));
    }

    @Test
    public void addSectionForm() throws Exception {
        ModelAndView mav = controller.addSectionForm();
        assertThat("addsectionform".equals(mav));
    }

    @Test
    public void testEditSection() throws Exception {
        Course someCourse = new Course();
        someCourse.setId("someCourseId");
        Professor someProfessor = new Professor();
        someProfessor.setId("someProfessorId");
        Schedule someSchedule = new Schedule();
        someSchedule.setId("someScheduleId");

        Section someSection = new Section();
        someSection.setId("someSectionId");
        someSection.setSchedule(someSchedule);
        someSection.setCourse(someCourse);
        someSection.setProfessor(someProfessor);

        sectionRepository.save(someSection);

        ModelAndView mav = controller.editSection("someSectionId");
        assertThat("editsectionform".equals(mav));
    }

    @Test
    public void deleteSection() throws Exception {
        Course someCourse = new Course();
        someCourse.setId("someCourseId");
        Professor someProfessor = new Professor();
        someProfessor.setId("someProfessorId");
        Schedule someSchedule = new Schedule();
        someSchedule.setId("someScheduleId");

        Section someSection = new Section();
        someSection.setId("someSectionId");
        someSection.setSchedule(someSchedule);
        someSection.setCourse(someCourse);
        someSection.setProfessor(someProfessor);

        sectionRepository.save(someSection);

        String mav = controller.deleteSection("someSectionId");
        assertThat("redirect:/sections/".equals(mav));

    }

//    @Test
//    public void sectionsBySemester() throws Exception {
//        Semester someSemester = new Semester();
//        semesterRepository.save(someSemester);
//
//        someSemester.setId("someSemesterId");
//        Course someCourse = new Course();
//        someCourse.setId("someCourseId");
//        Professor someProfessor = new Professor();
//        someProfessor.setId("someProfessorId");
//        Schedule someSchedule = new Schedule();
//        someSchedule.setId("someScheduleId");
//        someSchedule.setSemester(someSemester);
//
//        Section someSection = new Section();
//        someSection.setId("someSectionId");
//        someSection.setSchedule(someSchedule);
//        someSection.setCourse(someCourse);
//        someSection.setProfessor(someProfessor);
//
//        sectionRepository.save(someSection);
//
//        ModelAndView ret = controller.sectionsBySemester("someSemesterId");
//        assertThat("allsections".equals(ret));
//    }

    @Test
    public void selectSemester() throws Exception {
    }

}