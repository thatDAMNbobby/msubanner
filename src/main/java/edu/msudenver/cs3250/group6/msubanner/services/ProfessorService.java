package edu.msudenver.cs3250.group6.msubanner.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.msudenver.cs3250.group6.msubanner.entities.Professor;
import edu.msudenver.cs3250.group6.msubanner.repositories.ProfessorRepository;

/**
 * The professor service class.
 */

@Service
public class ProfessorService {

    /** The professor repository. */
    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Gets the list of all professors.
     *
     * @return the list of all professors
     */
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    /**
     * Gets a professor by id.
     * @param id the professor id
     * @return the professor
     */
    public Professor getProfessor(final String id) {
        return professorRepository.findOne(id);
    }

    /**
     * Adds a professor.
     * @param professor the professor to add
     */
    public void addProfessor(final Professor professor) {
        professorRepository.save(professor);
    }

    /**
     * Updates a user.
     * @param professor the professor to update
     */
    public void updateProfessor(final Professor professor) {
        professorRepository.save(professor);
    }

    /**
     * Deletes a professor.
     * @param id the professor id
     */
    public void deleteProfessor(final String id) {
        professorRepository.delete(id);
    }


}
