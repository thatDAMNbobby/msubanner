package edu.msudenver.cs3250.group6.msubanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.msudenver.cs3250.group6.msubanner.repositories.SectionRepository;
import edu.msudenver.cs3250.group6.msubanner.entities.Section;

import java.util.ArrayList;
import java.util.List;

/**
 * The section service.
 */
@Service
public class SectionService {

    /** The section repository. */
    @Autowired
    private SectionRepository sectionRepository;

    /**
     * Gets the list of all sections.
     * @return the list of all sections
     */
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    /**
     * Gets a section by id.
     * @param id the section id
     * @return the section
     */
    public Section getSection(final String id) {
        return sectionRepository.findById(id);
    }

    /**
     * Adds a section.
     * @param section the section to add
     */
    public void addSection(final Section section) {
        sectionRepository.save(section);
    }

    /**
     * Updates a section.
     * @param section the section to update
     */
    public void updateSection(final Section section) {
        sectionRepository.save(section);
    }

    /**
     * Deletes a section.
     * @param id the section id
     */
    public void deleteSection(final String id) {
        sectionRepository.delete(id);
    }

    /**
     * Gets all sections in a given semester.
     *
     * @param semester String value of semester
     * @return List containing the sections
     */
    public List<Section> getSectionsBySemester(final String semester) {
        return sectionRepository.findSectionsByScheduleSemester(semester);
    }
}
