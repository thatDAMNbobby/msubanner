package edu.msudenver.cs3250.group6.msubanner.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;
import edu.msudenver.cs3250.group6.msubanner.repositories.ScheduleRepository;

/**
 * The schedule service.
 */
@Service
public class ScheduleService {
    /** The room repository. */
    @Autowired
    private ScheduleRepository scheduleRepository;

    /**
     * Gets all schedules.
     *
     * @return the list of schedules
     */
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    /**
     * Gets a schedule by id.
     *
     * @param id the schedule id
     * @return the schedule
     */
    public Schedule getSchedule(final String id) {
        return scheduleRepository.findOne(id);
    }

    /**
     * Adds a schedule.
     *
     * @param schedule the {@link Schedule} to add
     */
    public void addSchedule(final Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    /**
     * Updates a schedule.
     *
     * @param schedule the Schedule to update
     */
    public void updateSchedule(final Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    /**
     * Deletes a schedule.
     *
     * @param id the schedule id
     */
    public void deleteSchedule(final String id) {
        scheduleRepository.delete(id);
    }
}
