package edu.msudenver.cs3250.group6.msubanner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClassLevelTest {

    @Test
    public void testGetDisplayName() {
        assertEquals("Freshman", ClassLevel.FRESHMAN.getDisplayName());
        assertEquals("Sophomore", ClassLevel.SOPHOMORE.getDisplayName());
        assertEquals("Junior", ClassLevel.JUNIOR.getDisplayName());
        assertEquals("Senior", ClassLevel.SENIOR.getDisplayName());
    }

    @Test
    public void testGetMinCredits() {
        assertEquals(0, ClassLevel.FRESHMAN.getMinCredits());
        assertEquals(30, ClassLevel.SOPHOMORE.getMinCredits());
        assertEquals(60, ClassLevel.JUNIOR.getMinCredits());
        assertEquals(90, ClassLevel.SENIOR.getMinCredits());
    }

    @Test
    public void testToString() {
        assertEquals("Freshman: 0 minimum credits", ClassLevel.FRESHMAN.toString());
        assertEquals("Sophomore: 30 minimum credits", ClassLevel.SOPHOMORE.toString());
        assertEquals("Junior: 60 minimum credits", ClassLevel.JUNIOR.toString());
        assertEquals("Senior: 90 minimum credits", ClassLevel.SENIOR.toString());
    }

}
