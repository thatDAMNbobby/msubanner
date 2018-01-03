package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.msudenver.cs3250.group6.msubanner.Global;

/*
 *  The purpose here is to get a mapping to the index.html in templates
 *  from: https://spring.io/blog/2016/11/21
 *          /the-joy-of-mustache-server-side-templates-for-the-jvm
 *        https://springframework.guru
 *          /spring-boot-web-application-part-2-using-thymeleaf/
 */

/**
 * Controller for mapping to index.html home page.
 */
@Controller
class HomeController {

    /**
     * Maps the home page to index.html.
     *
     * @return the index string
     */
    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
