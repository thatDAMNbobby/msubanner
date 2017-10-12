package edu.msudenver.cs3250.group6.msubanner.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * @return the list of all sections
     */
    @RequestMapping("/sections")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    /**
     * Gets a section by id number.
     * @param id the section id
     * @return the section
     */
    @RequestMapping("/sections/getsection/{id}")
    public Section getSection(@PathVariable final long id) {
        return sectionService.getSection(id);
    }

    /**
     * Adds a section.
     * @param section the section to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sections/addsection")
    public void addSection(@RequestBody final Section section) {
        sectionService.addSection(section);
    }

    /**
     * Updates a section.
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
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
                    value = "/sections/deletesection/{id}")
    public void deleteSection(@PathVariable final long id) {
        sectionService.deleteSection(id);
    }
}
