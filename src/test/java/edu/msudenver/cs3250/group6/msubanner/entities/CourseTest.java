package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;

public class CourseTest {

    // setId should never be used, so this is fine
    @Test
    public void setIdSetIdTest() {
        Course course = new Course();
        course.setId("1");
        assertEquals("1", course.getId());
    }

    @Test
    public void setTitleGetTitleTest() {
        Course course = new Course();
        course.setTitle("Test title");
        assertEquals("Test title", course.getTitle());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullTitle() {
        Course course = new Course();
        course.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEmptyTitle() {
        Course course = new Course();
        course.setTitle("");
    }

    @Test
    public void setDescriptionGetDescriptionTest() {
        Course course = new Course();
        course.setDescription("Test description");
        assertEquals("Test description", course.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullDesc() {
        Course course = new Course();
        course.setDescription(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setEmptyDesc() {
        Course course = new Course();
        course.setDescription("");
    }

    @Test
    public void setCreditsGetCreditsTest() {
        Course course = new Course();
        course.setCredits(4);
        assertEquals(4, course.getCredits());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeCredits() {
        Course course = new Course();
        course.setCredits(-3);
    }

    @Test
    public void setObjectivesGetObjectivesTest() {
        Course course = new Course();
        course.setLearningObjectives("Some objectives");
        assertEquals("Some objectives", course.getLearningObjectives());
    }

    @Test
    public void setNullObjectives() {
        Course course = new Course();
        course.setLearningObjectives(null);
        assertEquals("Default learning objectives.",
                course.getLearningObjectives());
    }

    @Test
    public void setEmptyObjectives() {
        Course course = new Course();
        course.setLearningObjectives("");
        assertEquals("Default learning objectives.",
                course.getLearningObjectives());
    }

    @Test
    public void setPrereqsGetPrereqs() {
        Course course = new Course();
        course.setPrereqs(ClassLevel.SENIOR);
        assertEquals(ClassLevel.SENIOR, course.getPrereqs());
    }

    @Test
    public void setDeptGetDept() {
        Course course = new Course();
        Department testDept = new Department("test");
        course.setDepartment(testDept);
        assertEquals(testDept, course.getDepartment());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullDept() {
        Course course = new Course();
        course.setDepartment(null);
    }

    @Test
    public void equals() {
        Course course = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
        Course course2 = course;
        assertEquals(course, course2);

        assertFalse(course.equals(null));
        assertFalse(course.equals(new Department()));

        Course equalCourse = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
        equalCourse.setId("8");
        course.setId("8");
        assertEquals(course, equalCourse);
    }

    @Test
    public void defaultConstructorTest() {
        Course course = new Course();
        assertEquals("Empty title", course.getTitle());
        assertEquals("No description available", course.getDescription());
    }

    @Test
    public void emptyStringInConstructorTest() {
        Course course = new Course("", "", 0, "", ClassLevel.FRESHMAN,
                new Department("test"));
        assertEquals("Empty title", course.getTitle());
        assertEquals("No description available", course.getDescription());
    }

    @Test
    public void nullStringConstructorTest() {
        Course course = new Course(null, null, 0, null, null,
                new Department("test)"));
        assertEquals("Empty title", course.getTitle());
        assertEquals("No description available", course.getDescription());
        assertEquals("No learning objective available",
                course.getLearningObjectives());
        assertEquals(ClassLevel.FRESHMAN, course.getPrereqs());
    }

    @Test
    public void constructorTest() {
        Course course = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
        assertEquals("Test title", course.getTitle());
        assertEquals("Test description", course.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorCreditException() {
        Course course = new Course("Test title", "Test description", -2,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorDeptException() {
        Course course = new Course("Test title", "Test description", 1,
                "Test objectives", ClassLevel.FRESHMAN, null);
    }

    @Test
    public void toStringTest() {
        Course course = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
        assertEquals("Course{Id=null, Title= Test title, Description= "
                + "Test description}", course.toString());
    }

}
