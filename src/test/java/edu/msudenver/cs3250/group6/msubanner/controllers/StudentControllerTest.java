package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.Student;
import edu.msudenver.cs3250.group6.msubanner.repositories.StudentRepository;
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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentController controller;

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllStudents() throws Exception {
        ModelAndView ret = controller.getAllStudents();
        assertThat("students".equals(ret));
    }

    @Test
    public void testGetStudentById() throws Exception {
        Student student = new Student();
        student.setFirstName("Peter");
        student.setLastName("Pettigrew");
        student.setId("747372");

        ModelAndView mav = controller.getProfessor("747372");
        assertThat("student".equals(mav));
    }

    @Test
    public void testAddStudent() throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put("firstName", "Donald");
        body.put("lastName", "Drumpf");

        ModelAndView mav = controller.addStudent(body);
        assertThat("students".equals(mav));
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setFirstName("Peter");
        student.setLastName("Pettigrew");
        student.setId("747372");

        String someFirstName = "Prehensile";
        String someLastName = "Tail";

        studentRepository.save(student);

        ModelAndView mav = controller.updateStudent(someFirstName, someLastName, "747372");

        assertThat(mav.getViewName().equals("showstudent"));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Student student = new Student();
        student.setFirstName("Peter");
        student.setLastName("Pettigrew");
        student.setId("747372");

        studentRepository.save(student);

        ResponseEntity<Void> voidMsg = controller.deleteStudent("747372");

        assertThat("student".equals(voidMsg));
    }

    @Test
    public void testDeleteStudentVoid() throws Exception {
        controller.deleteStudent("808080");
        ResponseEntity<Void> voidMsg2 = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        assertThat("student".equals(voidMsg2));
    }

    @Test
    public void testDeleteStudentRedirect() throws Exception {
        Student student = new Student();
        student.setFirstName("Peter");
        student.setLastName("Pettigrew");
        student.setId("747372");

        studentRepository.save(student);

        ModelAndView mav = controller.deleteStudentRedirect("747372");

        assertThat("students".equals(mav));
    }

    @Test
    public void testAddStudentForm() throws Exception {
        ModelAndView mav = controller.addStudentForm();
        assertThat("addstudentform".equals(mav));
    }

    @Test
    public void editStudent() throws Exception {
        Student student = new Student();
        student.setFirstName("Peter");
        student.setLastName("Pettigrew");
        student.setId("747372");

        studentRepository.save(student);

        ModelAndView mav = controller.editUser("747372");
        assertThat("editstudentform".equals(mav));
    }

}
