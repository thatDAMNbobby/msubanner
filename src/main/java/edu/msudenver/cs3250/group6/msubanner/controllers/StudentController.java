package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Student;
import edu.msudenver.cs3250.group6.msubanner.services.StudentService;
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
 * Controller for Student class
 */
@Controller
public class StudentController {

    /** the student service*/
    @Autowired
    private StudentService studentService;

    /**
     * Gets the list of all users.
     *
     * @return the list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/students")
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView("students");
        mav.addObject("allstudents", studentService.getAllStudents());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a student by id number.
     *
     * @param id the student id
     * @return the student
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/students/getstudent/{id}")
    public ModelAndView getProfessor(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showstudent");
        mav.addObject("student", studentService.getStudent(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a student.
     *
     * @param body the student info
     * @return the student
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/students/addstudent")
    public ModelAndView addStudent(
            @RequestParam final Map<String, String> body) {
        System.out
                .println("Post request hit /students/addstudent containing "
                        + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        Student student = new Student();
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        student.setFirstName(firstName);
        student.setLastName(lastName);

        studentService.addStudent(student);
        ModelAndView mav = new ModelAndView("students");
        mav.addObject("allstudents", studentService.getAllStudents());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates an existing student.
     *
     * @param firstName the student's first name
     * @param lastName the student's last name
     * @param id the student's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/students/updatestudent/{id}")
    public ModelAndView updateStudent(@RequestParam final String firstName,
                                        final String lastName, @PathVariable final String id) {
        Student student = studentService.getStudent(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentService.updateStudent(student);
        ModelAndView mav = new ModelAndView("showstudent");
        mav.addObject("student", studentService.getStudent(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a Student.
     *
     * @param id the student id
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/students/deletestudent/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable final String id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            studentService.deleteStudent(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

    /**
     * Deletes the selected student.
     *
     * @param id The id of the student
     * @return ModelAndView containing the list of all students
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/students/deletestudent/{id}")
    public ModelAndView deleteStudentRedirect(@PathVariable final String id) {
        studentService.deleteStudent(id);
        ModelAndView mav = new ModelAndView("students");
        mav.addObject("allprofessors", studentService.getAllStudents());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add student form.
     *
     * @return ModelAndView containing the global school name, redirecting to
     *         the add student form
     */
    @RequestMapping("/students/addstudent")
    public ModelAndView addStudentForm() {
        ModelAndView mav = new ModelAndView("addstudentform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the edit student form.
     *
     * @param id The id of the selected student
     * @return ModeAndView containing the selected student
     */
    @RequestMapping("/students/editstudent/{id}")
    public ModelAndView editUser(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editstudentform");
        mav.addObject("user", studentService.getStudent(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
