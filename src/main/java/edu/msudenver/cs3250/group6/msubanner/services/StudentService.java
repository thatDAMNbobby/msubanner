package edu.msudenver.cs3250.group6.msubanner.services;


import edu.msudenver.cs3250.group6.msubanner.entities.Student;
import edu.msudenver.cs3250.group6.msubanner.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *the Student service class
 */

@Service
public class StudentService {

    /** the student Repository. */
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents(){
        return studentRepository.findAll();

    }

    /**
     * Gets a student by id.
     * @param id the student id
     * @return the student
     */
    public Student getStudent(final String id) {
        return studentRepository.findOne(id);
    }

    /**
     * Adds a student.
     * @param student the student to add
     */
    public void addStudent(final Student student) {  studentRepository.save(student);
    }

    /**
     * Updates a student.
     * @param student the student to update
     */
    public void updateStudent(final Student student) {
        studentRepository.save(student);
    }

    /**
     * Deletes a student.
     * @param id the student id
     */
    public void deleteStudent(final String id) {
        studentRepository.delete(id);
    }

}
