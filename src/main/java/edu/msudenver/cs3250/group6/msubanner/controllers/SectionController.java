package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.*;
import edu.msudenver.cs3250.group6.msubanner.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

/**
 * The controller for the section class.
 */
@Controller
public class SectionController {

    /** The section service. */
    @Autowired
    private SectionService sectionService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private SemesterService semesterService;

    /**
     * Gets the list of all sections.
     *
     * @return the list of all sections
     */
    @RequestMapping("/sections")
    public ModelAndView getAllSections() {
        ModelAndView mav = new ModelAndView("sections");
        mav.addObject("allsections", sectionService.getAllSections());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a section by id number.
     *
     * @param id the section id
     * @return the section
     */
    @RequestMapping("/sections/getsection/{id}")
    public ModelAndView getSection(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showsection");
        mav.addObject("section", sectionService.getSection(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a section.
     *
     * @param course The course the section belongs to
     * @return the section
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sections/addsection")
    public ModelAndView addSection(@RequestParam final Course course,
                                   @RequestParam final User professor, final Schedule schedule) {
        Section section = new Section(course, professor, schedule);
        System.out.println("Adding section " + course.getTitle() + " Taught by " + professor.getLastName() + ", " + professor.getFirstName());
        sectionService.addSection(section);


        ModelAndView mav = new ModelAndView("sections");
        mav.addObject("allsections", sectionService.getAllSections());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a section.
     *
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/sections/updatesection/{id}")
    public ModelAndView updateSection(@RequestParam final Course course, final User professor,
            final Schedule schedule, @PathVariable final String id) {
        Section section = sectionService.getSection(id);
        section.setCourse(course);
        section.setProfessor(professor);
        section.setSchedule(schedule);
        sectionService.updateSection(section);
        ModelAndView mav = new ModelAndView("showsection");
        mav.addObject("section", section);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
    /**
     * Maps to the add section form.
     *
     * @return the add section form string
     */
    @RequestMapping("sections/addsection")
    ModelAndView addSectionForm() {
        ModelAndView mav = new ModelAndView("addsectionform");
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("allprofs", userService.getAllUsers());
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        mav.addObject("allsemesters", semesterService.getAllSemesters());

        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
    /**
     * Maps to the add section form.
     * @param id the id of the section
     * @return ModelAndView containing the selected section
     */
    @RequestMapping("/sections/editsection/{id}")
    public ModelAndView editSection(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editsectionform");
        Section section = sectionService.getSection(id);

        mav.addObject("section", section);
        mav.addObject("thiscourse", section.getCourse());
        mav.addObject("thisprof", section.getProfessor());
        mav.addObject("allprofs", userService.getAllUsers());
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        return mav;
    }

    /**
     * Deletes a section.
     *
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/sections/deletesection/{id}")
    public String deleteSection(@PathVariable final String id) {
        sectionService.deleteSection(id);
        return "redirect:/sections/";
    }

    /**
     * Maps to the sections page with a list of all sections in a given semester.
     *
     * @param id String value of semester id
     * @return ModelAndView containing list of sections
     */
    @RequestMapping("/sections/bysemester")
    public ModelAndView sectionsBySemester(@RequestParam final String id) {
        Semester semester = semesterService.getSemester(id);

        ModelAndView mav = new ModelAndView("sections");
        mav.addObject("allsections", sectionService.getSectionsBySemester(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);

        System.out.println(sectionService.getSectionsBySemester(id));
        return mav;
    }

    /**
     * Maps to select semester page.
     *
     * @return ModelAndView directing to the page
     */
    @RequestMapping("/sections/selectsemester")
    public ModelAndView selectSemester() {
        ModelAndView mav = new ModelAndView("selectsemester");
        mav.addObject("allsemesters", semesterService.getAllSemesters());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
