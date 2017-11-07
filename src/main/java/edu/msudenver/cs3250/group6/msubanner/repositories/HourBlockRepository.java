package edu.msudenver.cs3250.group6.msubanner.repositories;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.HourBlock;

/**
 * Repository for HourBlock class.
 */
@RepositoryRestResource
@Persistent
public interface HourBlockRepository
        extends MongoRepository<HourBlock, String> {
    /**
     * Finds an hour block by id.
     *
     * @param id the hour block id
     * @return the hourblock
     */
    HourBlock findById(String id);
}
