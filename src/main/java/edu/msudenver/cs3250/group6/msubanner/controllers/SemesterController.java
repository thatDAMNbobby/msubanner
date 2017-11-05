package edu.msudenver.cs3250.group6.msubanner.controllers;


import edu.msudenver.cs3250.group6.msubanner.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * The controller for the Semester class
 */
@Controller
public class SemesterController {

    /** The Semester service. */
    @Autowired
    private SemesterService semesterService;


}
