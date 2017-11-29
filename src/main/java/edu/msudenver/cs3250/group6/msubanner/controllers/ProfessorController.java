package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Professor;
import edu.msudenver.cs3250.group6.msubanner.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Controller for Professor class
 *
 * @author Group 6
 */
@Controller
public class ProfessorController {

    /** The professor service*/
    @Autowired
    private ProfessorService professorService;

    /**
     * Gets the list of all users.
     *
     * @return the list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/professors")
    public ModelAndView getAllProfessors() {
        ModelAndView mav = new ModelAndView("professors");
        mav.addObject("allprofessors", professorService.getAllProfessors());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a professor by id number.
     *
     * @param id the professor id
     * @return the professor
     */
    @RequestMapping(method = RequestMethod.GET, value = "/professors/getprofessor/{id}")
    public ModelAndView getProfessor(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showprofessor");
        mav.addObject("professor", professorService.getProfessor(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a professor.
     *
     * @param body the professor info
     * @return the professor
     */
    @RequestMapping(method = RequestMethod.POST, value = "/professors/addprofessor")
    public ModelAndView addProfessor(@RequestParam final Map<String, String> body) {
        System.out.println("Post request hit /professors/addprofessor containing "
                + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        Professor professor = new Professor();
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        professor.setFirstName(firstName);
        professor.setLastName(lastName);

        professorService.addProfessor(professor);
        ModelAndView mav = new ModelAndView("professors");
        mav.addObject("allprofessors", professorService.getAllProfessors());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates an existing professor.
     *
     * @param firstName the professor's first name
     * @param lastName the professor's last name
     * @param id the professor's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/professors/updateprofessor/{id}")
    public ModelAndView updateProfessor(@RequestParam final String firstName,
                                   final String lastName, @PathVariable final String id) {
        Professor professor = professorService.getProfessor(id);
        professor.setFirstName(firstName);
        professor.setLastName(lastName);
        professorService.updateProfessor(professor);
        ModelAndView mav = new ModelAndView("showprofessor");
        mav.addObject("professor", professorService.getProfessor(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a Professor.
     *
     * @param id the professor id
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/professors/deleteprofessor/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable final String id) {
        Professor professor = professorService.getProfessor(id);
        if (professor == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            professorService.deleteProfessor(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

    /**
     * Deletes the selected professor.
     *
     * @param id The id of the professor
     * @return ModelAndView containing the list of all professors
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/professors/deleteprofessor/{id}")
    public ModelAndView deleteProfessorRedirect(@PathVariable final String id) {
        professorService.deleteProfessor(id);
        ModelAndView mav = new ModelAndView("professors");
        mav.addObject("allprofessors", professorService.getAllProfessors());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add professor form.
     *
     * @return ModelAndView containing the global school name, redirecting to
     *         the add professor form
     */
    @RequestMapping("/professors/addprofessor")
    public ModelAndView addProfessorForm() {
        ModelAndView mav = new ModelAndView("addprofessorform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the edit professor form.
     *
     * @param id The id of the selected professor
     * @return ModeAndView containing the selected professor
     */
    @RequestMapping("/professors/editprofessor/{id}")
    public ModelAndView editUser(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editprofessorform");
        mav.addObject("user", professorService.getProfessor(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
