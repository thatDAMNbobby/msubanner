package edu.msudenver.cs3250.group6.msubanner.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import edu.msudenver.cs3250.group6.msubanner.repositories.CourseRepository;
import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Professor;
import edu.msudenver.cs3250.group6.msubanner.repositories.ProfessorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfessorControllerTest {

    @Autowired
    private ProfessorController controller;

    @Autowired
    ProfessorRepository professorRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllProfessors() throws Exception {
        ModelAndView ret = controller.getAllProfessors();
        assertThat("professors".equals(ret));
    }

    @Test
    public void testGetProfessorById() throws Exception {
        Professor  someProfessor = new Professor("Test", "Prof");
        someProfessor.setId("100");
        professorRepository.save(someProfessor);

        ModelAndView mav = controller.getProfessor("100");
        assertThat("showprofessor".equals(mav));
    }

    @Test
    public void testAddProfessor() throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put("firstName","fn");
        body.put("lastName", "ln");

        ModelAndView mav = controller.addProfessor(body);

        assertThat("showprofessor".equals(mav));
    }

    @Test
    public void testUpdateProfessor() throws Exception {
        Professor  someProfessor = new Professor("Test", "Prof");
        someProfessor.setId("100");
        professorRepository.save(someProfessor);

        String someProfessorName = "Marinated Mammals";

        ModelAndView mav = controller.updateProfessor("Test", "Prof", "100");

        assertThat(mav.getViewName().equals("showprofessor"));
    }

    @Test
    public void testDeleteProfessor() throws Exception {
        Professor  someProfessor = new Professor("Test", "Prof");
        someProfessor.setId("100");
        professorRepository.save(someProfessor);

        ResponseEntity<Void> mav = controller.deleteProfessor("100");

        assertThat(HttpStatus.GONE.equals(mav));

    }

    @Test
    public void testEditProfessor() {
        ModelAndView mav = controller.editUser("65");
        assertThat("editprofessorform".equals(mav));
    }

    @Test
    public void testAddProfessorForm() throws Exception {
        ModelAndView mav = controller.addProfessorForm();
        assertThat("addprofessorform".equals(mav));
    }

    @Test
    public void testDeleteProfessorRedirect() {
        ModelAndView mav = controller.deleteProfessorRedirect("65");
        assertThat("professors".equals(mav));
    }
}
