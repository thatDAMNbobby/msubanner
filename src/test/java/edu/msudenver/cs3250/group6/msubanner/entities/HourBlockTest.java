package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HourBlockTest {

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

    @Test(expected = Exception.class)
    public void setLowInvalidStartTime() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setStartTime(5);

        lowThrown.expect(IllegalArgumentException.class);
        lowThrown.expectMessage("Start Time must be an integer between 6 and 20");
    }

    @Rule
    public ExpectedException highThrown = ExpectedException.none();

    @Test(expected = Exception.class)
    public void setHighInvalidStartTime() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setStartTime(21);

        highThrown.expect(IllegalArgumentException.class);
        highThrown.expectMessage("Start Time must be an integer between 6 and 20");
    }

    @Test
    public void setValidDuration() {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setDuration(1);
        assertEquals(1, hourBlock.getDuration());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = Exception.class)
    public void setInvalidDuration() throws IllegalArgumentException {
        HourBlock hourBlock = new HourBlock();
        hourBlock.setDuration(21);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Duration must be an integer between 1 and 3");
    }

    @Test
    public void equalsTest1() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(6);
        hourBlock2.setStartTime(6);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(3);

        assertEquals(hourBlock, hourBlock2);
    }

    @Test
    public void equalsTestOverriddenEquals() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(6);
        hourBlock2.setStartTime(6);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(3);

        assertEquals(true, hourBlock2.equals(hourBlock));
    }

    @Test
    public void equalsTestFalse() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(6);
        hourBlock2.setStartTime(7);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(3);

        assertEquals(false, hourBlock2.equals(hourBlock));
    }

    @Test
    public void hasConflictTestTrueSameStartTime() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(7);
        hourBlock2.setStartTime(7);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(3);

        assertEquals(true, hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestTrue() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(7);
        hourBlock2.setStartTime(8);

        hourBlock.setDuration(2);
        hourBlock2.setDuration(3);

        assertEquals(true, hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestTrue2() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(8);
        hourBlock2.setStartTime(7);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(2);

        assertEquals(true, hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestFalse() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(7);
        hourBlock2.setStartTime(8);

        hourBlock.setDuration(1);
        hourBlock2.setDuration(3);

        assertEquals(false, hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestFalse2() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(8);
        hourBlock2.setStartTime(7);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(1);

        assertEquals(false, hourBlock2.hasConflict(hourBlock));
    }

    @Test
    public void hasConflictTestFalse3() {
        HourBlock hourBlock = new HourBlock();
        HourBlock hourBlock2 = new HourBlock();

        hourBlock.setStartTime(7);
        hourBlock2.setStartTime(10);

        hourBlock.setDuration(3);
        hourBlock2.setDuration(3);

        assertEquals(false, hourBlock2.hasConflict(hourBlock));
    }

}