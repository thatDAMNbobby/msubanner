package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.User;

/**
 * Data repository interface for User class. Using Repository pattern over DAO
 * pattern due to available documentation.
 */
@RepositoryRestResource
@Persistent
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Finds a user by id.
     *
     * @param id the user's id
     * @return the user
     */
    User findById(String id);

    /**
     * Finds all users.
     *
     * @return the list of users
     */
    List<User> findAll();
}
