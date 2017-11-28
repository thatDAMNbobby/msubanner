package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HourBlockTest {

    @Test
    public void constructorTest() {
        HourBlock testBlock1 = new HourBlock();
        assertEquals(6, testBlock1.getStartTime());
        assertEquals(1, testBlock1.getDuration());

        HourBlock testBlock2 = new HourBlock(7, 2);
        assertEquals(7, testBlock2.getStartTime());
        assertEquals(2, testBlock2.getDuration());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooEarlyStartTimeConstructor() {
        HourBlock testBlock = new HourBlock(5, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLateStartTimeConstructor() {
        HourBlock testBlock = new HourBlock(21, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooLongDurationConstructor() {
        HourBlock testBlock = new HourBlock(6, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooShortDurationConstructor() {
        HourBlock testBlock = new HourBlock(6, 0);
    }

    @Test
    public void setIdSetIdTest() {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setId("1");
        assertEquals("1", hourBlock.getId());
    }

    @Test
    public void setValidStartTime() {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setStartTime(6);
        assertEquals(6, hourBlock.getStartTime());
    }

    @Rule
    public ExpectedException lowThrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void setLowInvalidStartTime() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setStartTime(5);
    }

    @Rule
    public ExpectedException highThrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void setHighInvalidStartTime() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setStartTime(21);
    }

    @Test
    public void setValidDuration() {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setDuration(1);
        assertEquals(1, hourBlock.getDuration());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void setHighInvalidDuration() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setDuration(21);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLowInvalidDuration() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setDuration(0);
    }

    @Test
    public void equalsTest() {
        HourBlock hourBlock = new HourBlock(6, 3);
        HourBlock hourBlock2 = new HourBlock(6, 3);

        assertEquals(hourBlock, hourBlock2);
        assertEquals(hourBlock, hourBlock);
        assertFalse(hourBlock.equals(null));
        assertFalse(hourBlock.equals("Not an hour block"));

        HourBlock hourBlock3 = new HourBlock(6, 2);
        HourBlock hourBlock4 = new HourBlock(7, 3);

        assertFalse(hourBlock.equals(hourBlock3));
        assertFalse(hourBlock.equals(hourBlock4));
    }

    @Test
    public void hasConflictTestTrueSameStartTime() {
        HourBlock hourBlock = new HourBlock(7, 3);
        HourBlock hourBlock2 = new HourBlock(7, 3);
        assertTrue(hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestTrue() {
        HourBlock hourBlock = new HourBlock(7, 2);
        HourBlock hourBlock2 = new HourBlock(8, 3);
        assertTrue(hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestTrue2() {
        HourBlock hourBlock = new HourBlock(8, 3);
        HourBlock hourBlock2 = new HourBlock(7, 2);
        assertTrue(hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestFalse() {
        HourBlock hourBlock = new HourBlock(7, 1);
        HourBlock hourBlock2 = new HourBlock(8, 3);
        assertFalse(hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestFalse2() {
        HourBlock hourBlock = new HourBlock(8, 3);
        HourBlock hourBlock2 = new HourBlock(7, 1);
        assertFalse(hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestFalse3() {
        HourBlock hourBlock = new HourBlock(7, 3);
        HourBlock hourBlock2 = new HourBlock(10, 3);
        assertFalse(hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictBadComparison() {
        HourBlock hourBlock = new HourBlock();
        assertFalse(hourBlock.hasConflict(null));
        assertFalse(hourBlock.hasConflict("Not a block"));
    }

    @Test
    public void hasConflictWithSelf() {
        HourBlock hourBlock = new HourBlock();
        assertTrue(hourBlock.hasConflict(hourBlock));
    }

    @Test
    public void toStringTest() {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setId("1");
        String testString = "HourBlock{id = 1, startTime = 6, duration = 1}";
        assertEquals(testString, hourBlock.toString());
    }
}