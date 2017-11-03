package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Section repository.
 */
@RepositoryRestResource
public interface SectionRepository extends MongoRepository<Section, String> {
    public Section findById(String id);
    public List<Section> findAll();
    public List<Section> findAllByProfessor_Id(String id);
    public List<Section> findSectionsByScheduleSemester(String semester);

}

