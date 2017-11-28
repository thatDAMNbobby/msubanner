package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnrollmentTest {


    @Test
    public void testHasConflict() {
        Enrollment enrollment = new Enrollment();
        assertFalse(enrollment.hasConfilct());
    }

    @Test
    public void testConstructor() throws Exception {
        Student student = new Student();
        Section section = new Section();
        Enrollment enrollment = new Enrollment(student, section);
    }

    @Test
    public void testSetId() {
        Enrollment enrollment = new Enrollment();
        enrollment.setId("58");
        assertEquals("58", enrollment.getId());
    }

    @Test
    public void testSetStudent() {
        Enrollment enrollment = new Enrollment();
        Student student = new Student("Test", "Student");
        enrollment.setStudent(student);
        assertEquals(student, enrollment.getStudent());
    }

    @Test
    public void testSetSection() {
        Enrollment enrollment = new Enrollment();
        Section section = new Section();
        enrollment.setSection(section);
        assertEquals(section, enrollment.getSection());
    }
}