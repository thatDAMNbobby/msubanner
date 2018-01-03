package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DepartmentTest {
    @Test
    public void constructorNullEmptyTest() {
        Department department = new Department(null);
        assertEquals("Department Name", department.getDepartmentName());

        Department department2 = new Department("");
        assertEquals("Department Name", department2.getDepartmentName());
    }

    @Test
    public void getDepartmentNameTestDefault()  {
        Department department = new Department();
        assertEquals("Department Name", department.getDepartmentName());
    }

    @Test
    public void setIdTest()  {
        Department department = new Department();
        department.setId("1");
        assertEquals("1", department.getId());
    }

    @Test
    public void setDepartmentNameTest()  {
        Department department = new Department();
        department.setDepartmentName("Cars");
        assertEquals("Cars", department.getDepartmentName());
    }

    @Test
    public void equalsTestTrue()  {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("1");
        department2.setDepartmentName("Cats");

        assertTrue(department.equals(department2));
    }

    @Test
    public void equalsAutoFalse() {
        Department department = new Department();
        assertFalse(department.equals(null));
        assertFalse(department.equals("Not a department"));
    }

    @Test
    public void equalsTestFalseById()  {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("2");
        department2.setDepartmentName("Cats");

        assertEquals(false, department.equals(department2));
    }


    @Test
    public void equalsTestFalseByName()  {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("1");
        department2.setDepartmentName("Cars");

        assertEquals(false, department.equals(department2));
    }

    @Test
    public void hashCodeTest()  {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("1");
        department2.setDepartmentName("Cats");

        assertEquals(department.hashCode(), department2.hashCode());
    }

    @Test
    public void toStringTest()  {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        assertEquals("Department{id = 1, departmentName = Cats}", department.toString());
    }
}
