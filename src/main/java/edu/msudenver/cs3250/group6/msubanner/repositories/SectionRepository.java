package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Section;

/**
 * Section repository.
 */
@RepositoryRestResource
public interface SectionRepository extends MongoRepository<Section, String> {
    /**
     * Finds a section by id.
     *
     * @param id the section id
     * @return the section
     */
    Section findById(String id);

    /**
     * Finds all sections.
     *
     * @return the list of sections
     */
    List<Section> findAll();

    /**
     * Finds all sections under a professor.
     *
     * @param id the professor's id
     * @return the sections
     */
    List<Section> findAllByProfessorId(String id);

    /**
     * Finds all sections under a specific semester.
     *
     * @param semester the semester
     * @return the list of sections
     */
    List<Section> findAllByScheduleSemester(String semester);

}

