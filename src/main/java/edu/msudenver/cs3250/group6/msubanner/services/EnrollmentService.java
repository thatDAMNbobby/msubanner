package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.Enrollment;
import edu.msudenver.cs3250.group6.msubanner.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    /** The Enrollment repository. */
    @Autowired
    private EnrollmentRepository enrollmentRepository;


    /**
     * Gets the list of all Enrollments.
     * @return the list of all Enrollments
     */
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    /**
     * Gets a Enrollment by id.
     * @param id the Enrollment id
     * @return the Enrollment
     */
    public Enrollment getEnrollment(final String id) {
        return enrollmentRepository.findOne(id);
    }

    /**
     * Adds an Enrollment.
     * @param enrollment the Enrollment to add
     */
    public void addEnrollment(final Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    /**
     * Updates an Enrollment.
     * @param enrollment the Enrollment to update
     */
    public void updateEnrollment(final Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    /**
     * Deletes an Enrollment.
     * @param id the Enrollment id
     */
    public void deleteEnrollment(final String id) {
        enrollmentRepository.delete(id);
    }
}
