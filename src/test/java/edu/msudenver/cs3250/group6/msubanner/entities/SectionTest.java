package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SectionTest {

    @Test
    public void sectionTest() {
        Section section = new Section();

    }

    @Test
    public void sectionWithArgsTest() {
        Course course = new Course();
        Professor prof = new Professor("Dr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        assertNotNull(course);
        assertNotNull(prof);
    }

 /*   @Test
    public void getId() {
        Section section = new Section();
        assertNotNull(section.getId());
    }*/

    @Test
    public void setId() {
        Section section = new Section();
        section.setId("99");
        assertEquals("99", section.getId());
    }

    @Test
    public void getProfessor() {
        Course course = new Course();
        Professor prof = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        assertEquals(prof, section.getProfessor());
    }

    @Test
    public void setProfessor() {
        Course course = new Course();
        Professor prof = new Professor();
        Section section = new Section();
        section.setProfessor(prof);
        assertEquals(prof, section.getProfessor());
    }

    @Test
    public void setCourseTest() {
        Course course = new Course();
        User prof = new User();
        Section section = new Section();
        section.setCourse(course);
        assertEquals(course, section.getCourse());
    }

    @Test
    public void getCourseTest() {
        Course course = new Course();
        Professor prof = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        assertEquals(course, section.getCourse());
    }

    /*@Test
    public void hashTest() {
        Section section = new Section();
        assertEquals(0, section.hashCode());
    }*/

    @Test
    public void toStringTest() {
        Course course = new Course();
        Professor prof = new Professor("Mr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        String out = "Section{" + "id=" + section.getId() + ", Course="
                + course.toString() + ", professor:" + prof.toString()
                + '}';
        assertEquals(out, section.toString());
    }
}
