package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class DaysTest {

    @Test
    public void SetIdSetIdTest() {
        Days days = new Days();
        days.setId("1");
        assertEquals("1", days.getId());
    }

    @Test
    public void testAddDayToDays() {
        Days days = new Days();

    }
}