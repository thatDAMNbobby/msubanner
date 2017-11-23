package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void testInvalidNamedStudent() {
        Student nullName = new Student(null, null);
        assertEquals("First_Name", nullName.getFirstName());
        assertEquals("Last_Name", nullName.getLastName());
        Student emptyNamed = new Student("", "");
        assertEquals("First_Name", emptyNamed.getFirstName());
        assertEquals("Last_Name", emptyNamed.getLastName());
    }

    @Test
    public void getId() {
        Student student = new Student();
        // assertNotEquals(0, student.getId());
    }

    @Test
    public void setFirstName() {
        Student student = new Student();
        student.setFirstName("test name");
        assertEquals("test name", student.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstNameNull() {
        Student student = new Student();
        student.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstNameEmpty() {
        Student student = new Student();
        student.setFirstName("");
    }

    @Test
    public void setLastName() {
        Student student = new Student();
        student.setLastName("test name");
        assertEquals("test name", student.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastNameNull() {
        Student student = new Student();
        student.setLastName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastNameEmpty() {
        Student student = new Student();
        student.setLastName("");
    }

    @Test
    public void setId() {
        Student student = new Student();
        student.setId("99999");
        assertEquals("99999", student.getId());
    }

    @Test
    public void getFirstName() {
        Student student = new Student("test name", "");
        assertEquals("test name", student.getFirstName());
    }

    @Test
    public void getLastName() {
        Student student = new Student("", "test name");
        assertEquals("test name", student.getLastName());
    }

    @Test
    public void testStudent() {
        Student student = new Student();
        assertEquals("Last_Name", student.getLastName());
        assertEquals("First_Name", student.getFirstName());
    }

    // not really testing anything, but makes for good coverage :/
   /* @Test
    public void testHashCode() {
        Student student = new Student();
        assertEquals(664411433, student.hashCode());
    }*/

    @Test
    public void testToString() {
        Student student = new Student();
        assertEquals("User: First_Name Last_Name " + student.getId(), student.toString());
    }

    @Test
    public void testEquals() {
        Student student1 = new Student("Student", "One");
        // must set id if not connected to db
        // otherwise all ids are set to 0
        student1.setId("1");

        // test null and object not an instanceof
        String notStudent = "Not a student at all";
        assertFalse(student1.equals(notStudent));
        assertFalse(student1.equals(null));

        // test same exact object
        assertTrue(student1.equals(student1));

        // test only different id
        Student student2 = new Student("Student", "One");
        student2.setId("2");
        assertFalse(student1.equals(student2));

        // test only different first name
        Student student3 = new Student("Different", "One");
        student3.setId("1");
        assertFalse(student1.equals(student3));

        // test only different last name
        Student student4 = new Student("Student", "Different");
        student4.setId(student1.getId());
        assertFalse(student1.equals(student4));

        // test all values the same
        Student studentCopy = new Student();
        studentCopy.setFirstName(student1.getFirstName());
        studentCopy.setLastName(student1.getLastName());
        studentCopy.setId(student1.getId());
        assertTrue(student1.equals(studentCopy));
    }

}