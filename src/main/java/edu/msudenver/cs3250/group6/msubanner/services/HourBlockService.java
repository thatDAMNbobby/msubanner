package edu.msudenver.cs3250.group6.msubanner.services;

import edu.msudenver.cs3250.group6.msubanner.entities.HourBlock;
import edu.msudenver.cs3250.group6.msubanner.repositories.HourBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HourBlockService {

    @Autowired
    private HourBlockRepository hourBlockRepository;

    public HourBlock getHourBlock(final String id) { return hourBlockRepository.findById(id); }

    public void addHourBlock(final HourBlock hourBlock) { hourBlockRepository.save(hourBlock); }

    public void updateHourBlock(final HourBlock hourBlock) { hourBlockRepository.save(hourBlock); }

    public void deleteHourBlock(final String id) { hourBlockRepository.delete(id); }

}
