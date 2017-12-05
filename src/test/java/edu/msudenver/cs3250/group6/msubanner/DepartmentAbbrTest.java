package edu.msudenver.cs3250.group6.msubanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentAbbrTest {

    @Test
    public void testGetDisplayName(){
        assertEquals("CS", DepartmentAbbr.CS.getDisplayName());
        assertEquals("MTH", DepartmentAbbr.MTH.getDisplayName());
        assertEquals("CIS", DepartmentAbbr.CIS.getDisplayName());
    }

    @Test
    public void testToString(){
        assertEquals("CS", DepartmentAbbr.CS.getDisplayName());
        assertEquals("MTH", DepartmentAbbr.MTH.getDisplayName());
        assertEquals("CIS", DepartmentAbbr.CIS.getDisplayName());
    }
}