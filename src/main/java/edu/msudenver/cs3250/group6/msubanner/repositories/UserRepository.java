package edu.msudenver.cs3250.group6.msubanner.repositories;

import edu.msudenver.cs3250.group6.msubanner.entities.User;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Data repository interface for User class.
 * Using Repository pattern over DAO pattern due to available documentation.
 */
@RepositoryRestResource
@Persistent
public interface UserRepository extends CrudRepository<User, Long> {
        }
