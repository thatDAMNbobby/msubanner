package edu.msudenver.cs3250.group6.msubanner.repositories;


import edu.msudenver.cs3250.group6.msubanner.entities.Professor;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Data repository interface for Professor class. Using Repository pattern over DAO
 * pattern due to available documentation.
 */
@RepositoryRestResource
@Persistent
public interface ProfessorRepository extends MongoRepository<Professor, String> {

    /**
     * Finds a professor by id.
     *
     * @param id the professor's id
     * @return the professor
     */
    Professor findById(String id);

    /**
     * Finds all professors.
     *
     * @return the list of professors
     */
    List<Professor> findAll();
}
