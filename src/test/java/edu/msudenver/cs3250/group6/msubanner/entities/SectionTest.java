package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SectionTest {

    @Test
    public void sectionTest() {
        Section section = new Section();
        assertNotNull(section);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sectionTestCourseNull() {
        Course course = null;
        Professor professor = new Professor();
        Schedule schedule = new Schedule();

        Section section = new Section(course, professor, schedule);

        assertNotNull(section);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sectionTestProfessorNull() {
        Course course = new Course();
        Professor professor = null;
        Schedule schedule = new Schedule();

        Section section = new Section(course, professor, schedule);

        assertNotNull(section);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sectionTestScheduleNull() {
        Course course = new Course();
        Professor professor = new Professor();
        Schedule schedule = null;

        Section section = new Section(course, professor, schedule);

        assertNotNull(section);
    }

    @Test
    public void sectionTestCourseParameter() {
        Course course = new Course();
        Section section = new Section(course);

        assertNotNull(section);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sectionTestCourseParameterCourseNull() {
        Course course = null;
        Section section = new Section(course);

        assertNotNull(section);
    }



    @Test
    public void sectionWithArgsTest() {
        Course course = new Course();
        Professor prof = new Professor("Dr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        assertNotNull(course);
        assertNotNull(prof);
    }

    /*   @Test
    public void getId() {
        Section section = new Section();
        assertNotNull(section.getId());
    }*/

    @Test
    public void setId() {
        Section section = new Section();
        section.setId("99");
        assertEquals("99", section.getId());
    }

    @Test
    public void getProfessor() {
        Course course = new Course();
        Professor prof = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        assertEquals(prof, section.getProfessor());
    }

    @Test
    public void setProfessor() {
        Course course = new Course();
        Professor prof = new Professor();
        Section section = new Section();
        section.setProfessor(prof);
        assertEquals(prof, section.getProfessor());
    }

    @Test
    public void setCourseTest() {
        Course course = new Course();
        User prof = new User();
        Section section = new Section();
        section.setCourse(course);
        assertEquals(course, section.getCourse());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCourseNullTest() {
        Course course = null;
        Section section = new Section();
        section.setCourse(course);
        assertEquals(course, section.getCourse());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setProfessorNullTest() {
        Course course = new Course();
        Professor professor = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, professor, schedule);

        Professor professor2 = null;
        section.setProfessor(professor2);

        assertNotNull(section);
    }

    @Test
    public void getSchedule() {
        Course course = new Course();
        Professor professor = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, professor, schedule);

        assertEquals(schedule, section.getSchedule());
    }

    @Test
    public void setSchedule() {
        Course course = new Course();
        Professor professor = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, professor, schedule);

        Schedule schedule2 = new Schedule();
        section.setSchedule(schedule2);

        assertEquals(schedule2, section.getSchedule());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setScheduleNull() {
        Course course = new Course();
        Professor professor = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, professor, schedule);

        Schedule schedule2 = null;
        section.setSchedule(schedule2);

        assertEquals(schedule2, section.getSchedule());
    }

    @Test
    public void getCourseTest() {
        Course course = new Course();
        Professor prof = new Professor();
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        assertEquals(course, section.getCourse());
    }

    /*@Test
    public void hashTest() {
        Section section = new Section();
        assertEquals(0, section.hashCode());
    }*/

    @Test
    public void toStringTest() {
        Course course = new Course();
        Professor prof = new Professor("Mr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        String out = "Section{id = " + section.getId() + ", Course = "
                + course.toString() + ", professor = " + prof.toString()
                + "}";
        assertEquals(out, section.toString());
    }


    @Test
    public void equalsTest() {
        Course course = new Course();
        Professor prof = new Professor("Mr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        section.setId("55");
        Section section2 = new Section(course, prof, schedule);
        section2.setId("55");

        assertTrue(section.equals(section2));
        assertTrue(section.equals(section));

        //different id only
        Section section3 = new Section(course, prof, schedule);
        section3.setId("54");
        assertFalse(section.equals(section3));

        //different course only
        Section section4 = new Section(course, prof, schedule);
        section4.setId("55");
        section4.setCourse(new Course("A course", null, 0, null, null, new Department("CS")));
        assertFalse(section.equals(section4));

        //different professor only
        Section section5 = new Section(course, prof, schedule);
        section5.setId("55");
        section5.setProfessor(new Professor("Severus", "Snape"));
        assertFalse(section.equals(section5));

        //different schedule only
        Section section6 = new Section(course, prof, schedule);
        section6.setId("55");
        Schedule schedule2 = new Schedule();
        schedule2.setBuilding(new Building("Science"));
        section6.setSchedule(schedule2);
        assertFalse(section.equals(section6));
    }

    @Test
    public void equalsNullInstanceTest() {
        Course course = new Course();
        Professor prof = new Professor("Mr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        section.setId("55");
        Section section2 = null;

        assertFalse(section.equals(section2));
        assertFalse(section.equals("Not a section"));
    }

    @Test
    public void hashCodeTest() {
        Course course = new Course();
        Professor prof = new Professor("Mr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        section.setId("55");
        Section section2 = new Section(course, prof, schedule);
        section2.setId("55");

        assertEquals(section2.hashCode(), section.hashCode());
    }
}
