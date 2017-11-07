package edu.msudenver.cs3250.group6.msubanner.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;

/**
 * The schedule repository.
 */
@RepositoryRestResource
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    /**
     * Finds a schedule by id.
     *
     * @param id the schedule id
     * @return the schedule
     */
    Schedule findById(String id);

    /**
     * Finds all schedules.
     *
     * @return the list of schedules
     */
    List<Schedule> findAll();
}
