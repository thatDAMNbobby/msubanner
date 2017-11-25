package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorTest {
    @Test
    public void testInvalidNamedProfessor() {
        Professor nullName = new Professor(null, null);
        assertEquals("First_Name", nullName.getFirstName());
        assertEquals("Last_Name", nullName.getLastName());
        Professor emptyNamed = new Professor("", "");
        assertEquals("First_Name", emptyNamed.getFirstName());
        assertEquals("Last_Name", emptyNamed.getLastName());
    }

    @Test
    public void setIdTest() {
        Professor professor = new Professor();
        professor.setId("99999");
        assertEquals("99999", professor.getId());
    }

    @Test
    public void setFirstName() {
        Professor professor = new Professor();
        professor.setFirstName("test name");
        assertEquals("test name", professor.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstNameNull() {
        Professor professor = new Professor();
        professor.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstNameEmpty() {
        Professor professor = new Professor();
        professor.setFirstName("");
    }

    @Test
    public void setLastName() {
        Professor professor = new Professor();
        professor.setLastName("test name");
        assertEquals("test name", professor.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastNameNull() {
        Professor professor = new Professor();
        professor.setLastName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastNameEmpty() {
        Professor professor = new Professor();
        professor.setLastName("");
    }

    @Test
    public void setId() {
        Professor professor = new Professor();
        professor.setId("99999");
        assertEquals("99999", professor.getId());
    }

    @Test
    public void getFirstName() {
        Professor professor = new Professor("test name", "");
        assertEquals("test name", professor.getFirstName());
    }

    @Test
    public void getLastName() {
        Professor professor = new Professor("", "test name");
        assertEquals("test name", professor.getLastName());
    }

    @Test
    public void testProfessor() {
        Professor professor = new Professor();
        assertEquals("Last_Name", professor.getLastName());
        assertEquals("First_Name", professor.getFirstName());
    }

    // not really testing anything, but makes for good coverage :/
   /* @Test
    public void testHashCode() {
        Professor professor = new Professor();
        assertEquals(664411433, professor.hashCode());
    }*/

    @Test
    public void testToString() {
        Professor professor = new Professor();
        assertEquals("User: First_Name Last_Name " + professor.getId(), professor.toString());
    }

    @Test
    public void testEquals() {
        Professor professor1 = new Professor("Professor", "One");
        // must set id if not connected to db
        // otherwise all ids are set to 0
        professor1.setId("1");

        // test null and object not an instanceof
        String notProfessor = "Not a professor at all";
        assertFalse(professor1.equals(notProfessor));
        assertFalse(professor1.equals(null));

        // test same exact object
        assertTrue(professor1.equals(professor1));

        // test only different id
        Professor professor2 = new Professor("Professor", "One");
        professor2.setId("2");
        assertFalse(professor1.equals(professor2));

        // test only different first name
        Professor professor3 = new Professor("Different", "One");
        professor3.setId("1");
        assertFalse(professor1.equals(professor3));

        // test only different last name
        Professor professor4 = new Professor("Professor", "Different");
        professor4.setId(professor1.getId());
        assertFalse(professor1.equals(professor4));

        // test all values the same
        Professor professorCopy = new Professor();
        professorCopy.setFirstName(professor1.getFirstName());
        professorCopy.setLastName(professor1.getLastName());
        professorCopy.setId(professor1.getId());
        assertTrue(professor1.equals(professorCopy));
    }
}
