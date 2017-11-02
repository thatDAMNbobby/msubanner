package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class SemesterTest {

    @Test
    public void setIdTest() {
        Semester semester = new Semester();
        semester.setId("1");
        assertEquals("1", semester.getId());
    }
}