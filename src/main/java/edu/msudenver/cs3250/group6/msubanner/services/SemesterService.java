package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.Semester;
import edu.msudenver.cs3250.group6.msubanner.repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Semester service
 */
@Service
public class SemesterService {

    /** The Semester repository. */
    @Autowired
    private SemesterRepository semesterRepository;

    /**
     * Gets the list of all Semesters
     * @return the list of Semesters
     */
    public List<Semester> getAllSemesters() { return semesterRepository.findAll(); }

    /**
     * Gets a Semester by id
     * @param id the Semester id
     * @return the Semester
     */
    public Semester getSemester(final String id) { return semesterRepository.findOne(id); }

    /**
     * Adds a Semester.
     * @param semester the Semester to add
     */
    public void addSemester(final Semester semester) {
        semesterRepository.save(semester);
    }

    /**
     * Updates a Semester.
     * @param semester the Semester to update
     */
    public void updateSemester(final Semester semester) {
        semesterRepository.save(semester);
    }

    /**
     * Deletes a Semester.
     * @param id the Semester id
     */
    public void deleteSemester(final String id) {
        semesterRepository.delete(id);
    }
}

