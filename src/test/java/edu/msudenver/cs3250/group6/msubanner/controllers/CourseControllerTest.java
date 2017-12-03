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
public class CourseControllerTest {

    @Autowired
    private CourseController controller;

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllCourses() throws Exception {
        ModelAndView ret = controller.getAllCourses();
        assertThat("courses".equals(ret));
    }

    @Test
    public void testGetCourseById() throws Exception {

        Department  someCourseDepartment = new Department("Marine Mammals");

        Course course = new Course();
        course.setId("0101");
        course.setTitle("Swimming with Stupid Dolphins");
        course.setCredits(4);
        course.setLearningObjectives("Doing things on Porpoise");
        course.setDepartment(someCourseDepartment);
        courseRepository.save(course);

        ModelAndView mav = controller.getCourse("0101");
        assertThat("showcourse".equals(mav));
    }

    @Test
    public void testAddCourse() throws Exception {
        String someCourseTitle = "some course";
        String someCourseDescription = "some course description";
        int someCourseCredits = 4;
        String someCourseLearningObjectives = "some course learning objectives";
        ClassLevel someCoursePrereqs = ClassLevel.SENIOR;
        Department  someCourseDepartment = new Department();

        ModelAndView mav = controller.addCourse(someCourseTitle, someCourseDescription,
                                                someCourseCredits, someCourseLearningObjectives,
                                                someCoursePrereqs, someCourseDepartment);
        assertThat("showcourse".equals(mav));
    }

    @Test
    public void testUpdateCourse() throws Exception {
        Department  someCourseDepartment = new Department("Marine Mammals");

        Course course = new Course();
        course.setId("0101");
        course.setTitle("Swimming with Stupid Dolphins");
        course.setCredits(4);
        course.setLearningObjectives("Doing things on Porpoise");
        course.setDepartment(someCourseDepartment);
        courseRepository.save(course);

        String someCourseTitle = "some course";
        String someCourseDescription = "some course description";
        int someCourseCredits = 4;
        String someCourseLearningObjectives = "some course learning objectives";
        ClassLevel someCoursePrereqs = ClassLevel.SENIOR;
        Department someCourseDepartment1 = new Department();


        String someCourseTitle2 = "some course 2";
        String someCourseDescription2 = "some course description 2";
        int someCourseCredits2 = 3;
        String someCourseLearningObjectives2 = "some course learning objectives 2";
        ClassLevel someCoursePrereqs2 = ClassLevel.FRESHMAN;
        Department  someCourseDepartment2 = new Department();


        ModelAndView mav = controller.updateCourse(someCourseTitle, someCourseDescription,
                someCourseCredits, someCourseLearningObjectives,
                someCoursePrereqs, someCourseDepartment1, "0101");

        controller.updateCourse(someCourseTitle2, someCourseDescription2,
                someCourseCredits2, someCourseLearningObjectives2,
                someCoursePrereqs2, someCourseDepartment2, "0101");

        assertThat(mav.getViewName().equals("showcourse"));
    }

    @Test
    public void testDeleteCourse() throws Exception {
        Department  someCourseDepartment = new Department("Marine Mammals");

        Course course = new Course();
        course.setId("0101");
        course.setTitle("Swimming with Stupid Dolphins");
        course.setCredits(4);
        course.setLearningObjectives("Doing things on Porpoise");
        course.setDepartment(someCourseDepartment);
        courseRepository.save(course);

        ModelAndView mav = controller.deleteCourse("0101");
        assertThat("courses".equals(mav));
    }

    @Test
    public void testEditCourse() throws Exception {
        Department  someCourseDepartment = new Department("Marine Mammals");

        Course course = new Course();
        course.setId("0101");
        course.setTitle("Swimming with Stupid Dolphins");
        course.setCredits(4);
        course.setLearningObjectives("Doing things on Porpoise");
        course.setDepartment(someCourseDepartment);
        courseRepository.save(course);

        ModelAndView mav = controller.editCourse("0101");
        assertThat("editcourseform".equals(mav));
    }

    @Test
    public void testAddCourseForm() throws Exception {
        ModelAndView mav = controller.addCourseForm();
        assertThat("addcourseform".equals(mav));
    }
}
