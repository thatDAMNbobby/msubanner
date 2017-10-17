package edu.msudenver.cs3250.group6.msubanner.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.msudenver.cs3250.group6.msubanner.entities.User;
import edu.msudenver.cs3250.group6.msubanner.services.UserService;

/*
 * Reference:
 * www.bytestree.com/spring/restful-web-services-unit-testing-spring-boot/
 */

/**
 * Controller for the User class.
 *
 * @author Group 6
 */
@RestController
public class UserController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Gets the list of all users.
     *
     * @return the list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            users.add(new User("Database is", "Actually Empty"));
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * Gets a user by id number.
     *
     * @param id the user id
     * @return the user
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/getuser/{id}")
    public ResponseEntity<User> getUser(@PathVariable final long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * Adds a user.
     *
     * @param body the user info
     * @return the user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
    public ResponseEntity<User> addUser(
            @RequestParam final Map<String, String> body) {
        System.out.println("Post request hit /users/adduser containing "
                + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        User user = new User();
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        user.setFirstName(firstName);
        user.setLastName(lastName);

        userService.addUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    /**
     * Updates an existing user.
     *
     * @param user the user to be updated
     * @param id the user's id
     * @return void
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/users/updateuser/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody final User user,
            @PathVariable final long id) {
        User existingUser = userService.getUser(id);
        if (existingUser == null) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } else {
            userService.updateUser(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    /**
     * Deletes a user.
     *
     * @param id the user id
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/users/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.deleteUser(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
}
