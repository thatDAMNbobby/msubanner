package edu.msudenver.cs3250.group6.msubanner.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent Department class.
 */

public class Department {

    /** Department Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /** Department name. */
    @Column
    private String deptName;

    /** Default constructor for user class. */
    public Department() {
        this.deptName = "Department Name";
    }

    /**
     * Constructor.
     *
     * @param newDeptName the department name
     */
    public Department(final String newDeptName) {
        if (newDeptName == null || newDeptName.isEmpty()) {
            deptName = "Department Name";
        } else {
            deptName = newDeptName;
        }
    }

    /**
     * Returns the name of the Department.
     *
     * @return Department name
     */
    public String getDepartmentName() {
        return deptName;
    }

    /**
     * Returns the department id.
     *
     * @return Department id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the department name.
     *
     * @param newDeptName name to set department name to
     */
    public void setDepartmentName(final String newDeptName) {
        deptName = newDeptName;
    }

    /**
     * Sets the department's ID.
     *
     * @param newId ID to assign to the department
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;

        return Objects.equals(id, that.id)
                && Objects.equals(deptName, that.deptName);
    }

    /**
     * Generates hashcode for Department object.
     *
     * @return int value of hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.deptName);
    }

    /**
     * Returns a String for Department.
     *
     * @return String of Department values
     */
    @Override
    public String toString() {
        return "Department{id = " + id + ", departmentName = "
                + deptName + "}";
    }
}
