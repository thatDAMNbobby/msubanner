package edu.msudenver.cs3250.group6.msubanner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Section;
import edu.msudenver.cs3250.group6.msubanner.services.SectionService;

/**
 * The controller for the section class.
 */
@RestController
public class SectionController {

    /** The section service. */
    @Autowired
    private SectionService sectionService;

    /**
     * Gets the list of all sections.
     *
     * @return the list of all sections
     */
    @RequestMapping("/sections")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    /**
     * Gets a section by id number.
     *
     * @param id the section id
     * @return the section
     */
    @RequestMapping("/sections/getsection/{id}")
    public Section getSection(@PathVariable final long id) {
        return sectionService.getSection(id);
    }

    /**
     * Adds a section.
     *
     * @param course The course the section belongs to
     * @return the section
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sections/addsection")
    public ResponseEntity<Section> addSection(
            @RequestParam final Course course) {
        Section section = new Section(course);
        sectionService.addSection(section);
        return new ResponseEntity<Section>(section, HttpStatus.CREATED);
    }

    /**
     * Updates a section.
     *
     * @param section the section to be updated
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/sections/updatesection/{id}")
    public void updateSection(@RequestBody final Section section,
            @PathVariable final long id) {
        sectionService.updateSection(section);
    }

    /**
     * Deletes a section.
     *
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/sections/deletesection/{id}")
    public void deleteSection(@PathVariable final long id) {
        sectionService.deleteSection(id);
    }
}
