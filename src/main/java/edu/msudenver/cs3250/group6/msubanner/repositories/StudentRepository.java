package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Enrollment;
import edu.msudenver.cs3250.group6.msubanner.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    /**
     * Finds a Student by id.
     *
     * @param id the student's id
     * @return the student
     */
    Student findById(String id);

    /**
     * Finds all students
     *
     * @return the list of students
     */
    List<Student> findAll();


}
