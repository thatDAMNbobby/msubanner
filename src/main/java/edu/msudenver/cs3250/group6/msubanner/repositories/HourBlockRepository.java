package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.HourBlock;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * Repository for HourBlock class
 */
@RepositoryRestResource
@Persistent
public interface HourBlockRepository  extends MongoRepository<HourBlock, String> {
    public HourBlock findById(String id);

}
