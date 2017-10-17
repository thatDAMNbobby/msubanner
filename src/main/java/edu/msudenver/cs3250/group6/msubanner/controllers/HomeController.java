package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    String index() {
        return "index";
    }

    /**
     * Maps to the add user form.
     *
     * @return the add user form string
     */
    @RequestMapping("/users/adduser")
    String addUserForm() {
        return "adduserform";
    }

    /**
     * Maps to the add department form.
     *
     * @return the add department form string
     */
    @RequestMapping("/departments/adddepartment")
    String addDepartmentForm() {
        return "adddepartmentform";
    }

    /**
     * Maps to the add course form.
     *
     * @return the add course form string
     */
    @RequestMapping("/courses/addcourse")
    String addCourseForm() {
        return "addcourseform";
    }

    /**
     * Maps to the course show form.
     *
     * @return courseshow form string
     */
    @RequestMapping("/courseshow")
    String courseshow() {
        return "courseshow";
    }

    /**
     * Maps to the add section form.
     *
     * @return the add section form string
     */
    @RequestMapping("sections/addsection")
    String addSectionForm() {
        return "addsectionform";
    }

    /**
     * Maps to the add building form.
     *
     * @return the add building form string
     */
    @RequestMapping("/buildings/addbuilding")
    String addBuildingForm() {
        return "addbuildingform";
    }

    /**
     * Maps to the add room form.
     *
     * @return the add room form string
     */
    @RequestMapping("/rooms/addroom")
    String addRoomForm() {
        return "addroomform";
    }
}
