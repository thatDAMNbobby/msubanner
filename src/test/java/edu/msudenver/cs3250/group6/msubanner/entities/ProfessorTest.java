package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorTest {
    @Test
    public void testInvalidNamedProfessor() {
        Professor nullName = new Professor(null, null);
        assertEquals("First_Name", nullName.getFirstName());
        assertEquals("Last_Name", nullName.getLastName());
        Student emptyNamed = new Student("", "");
        assertEquals("First_Name", emptyNamed.getFirstName());
        assertEquals("Last_Name", emptyNamed.getLastName());
    }

    @Test
    public void setId() {
        Professor professor = new Professor();
        professor.setId("99999");
        assertEquals("99999", professor.getId());
    }

    @Test
    public void getFirstName() throws Exception {
    }

    @Test
    public void setFirstName() throws Exception {
    }

    @Test
    public void getLastName() throws Exception {
    }

    @Test
    public void setLastName() throws Exception {
    }

}