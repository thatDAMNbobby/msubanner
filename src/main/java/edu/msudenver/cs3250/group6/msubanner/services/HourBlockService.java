package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.HourBlock;
import edu.msudenver.cs3250.group6.msubanner.repositories.HourBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The HourBlock service
 */
@Service
public class HourBlockService {

    /** The HourBlock repository. */
    @Autowired
    private HourBlockRepository hourBlockRepository;

    /**
     * Gets an HourBlock by id.
     * @param id the HourBlock id
     * @return the HourBlock
     */
    public HourBlock getHourBlock(final String id) { return hourBlockRepository.findById(id); }

    /**
     * Adds a HourBlock
     * @param hourBlock the HourBlock to add
     */
    public void addHourBlock(final HourBlock hourBlock) { hourBlockRepository.save(hourBlock); }

    /**
     * Updates a HourBlock.
     * @param hourBlock the HourBlock to update
     */
    public void updateHourBlock(final HourBlock hourBlock) { hourBlockRepository.save(hourBlock); }

    /**
     * Deletes a HourBlock.
     * @param id the HourBlock to delete
     */
    public void deleteHourBlock(final String id) { hourBlockRepository.delete(id); }

}
