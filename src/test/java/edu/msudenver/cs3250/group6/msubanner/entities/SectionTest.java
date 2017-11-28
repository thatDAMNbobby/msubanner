package edu.msudenver.cs3250.group6.msubanner.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        String out = "Section{" + "id=" + section.getId() + ", Course="
                + course.toString() + ", professor:" + prof.toString()
                + '}';
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

        assertEquals(true, section.equals(section2));
        assertEquals(true, section.equals(section));
    }

    @Test
    public void equalsNullInstanceTest() {
        Course course = new Course();
        Professor prof = new Professor("Mr.", "Meseeks");
        Schedule schedule = new Schedule();
        Section section = new Section(course, prof, schedule);
        section.setId("55");
        Section section2 = null;

        assertEquals(false, section.equals(section2));
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
