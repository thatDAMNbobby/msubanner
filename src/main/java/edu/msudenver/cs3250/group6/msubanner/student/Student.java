package edu.msudenver.cs3250.group6.msubanner.student;

import edu.msudenver.cs3250.group6.msubanner.section.Section;
import edu.msudenver.cs3250.group6.msubanner.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {

    @Column
    private int credits;


    private Set<Section> sections;

    /**
     * Gets the student's credits
     * @return value of credits earned by the student
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the credits earned by the student
     * @param creds credits to set to the student
     */
    public  void setCredits(int creds) {
        credits = creds;
    }

    /**
     * Gets the sections this student is currently enrolled in
     * @return Set object containing all sections student is enrolled in
     */
    @OneToMany(mappedBy = "studentsSections", cascade = CascadeType.ALL)
    public  Set<Section> getSections() {
        return sections;
    }

    /**
     * Sets the sections the student is currently enrolled in
     * @param sections new set of sections for student to be enrolled in
     */
    public  void setSections(Set<Section> sections) {
        this.sections = sections;
    }


}
