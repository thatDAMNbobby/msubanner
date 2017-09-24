package edu.msudenver.cs3250.group6.msubanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * Reference:
 * www.bytestree.com/spring/restful-web-services-unit-testing-spring-boot/
 */

/**
 * Controller for the User class.
 * @author Group 6
 */
@RestController
public class UserController {

    /** The user service. */
    @Autowired
    private UserService userService;

    // @GetMapping("/user")
    // public String userForm(Model model) {
    // model.addAttribute("user", new User());
    // return "user";
    // }
    //
    // @PostMapping("/user")
    // public String userSubmit(@ModelAttribute User user) {
    // return "result";
    // }

    /**
     * Gets the list of all users.
     * @return the list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * Gets a user by id number.
     * @param id the user id
     * @return the user
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/getuser/{id}")
    //@PathVariable indicates use of {id} wildcard above
    public ResponseEntity<User> getUser(@PathVariable final long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * Adds a new user.
     * @param user the user to be added
     * @return the new user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
    // take request body, turn into User instance and pass to addUser()
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        // POST body should contain object being sent
        userService.addUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    /**
     * Updates an existing user.
     * @param user the user to be updated
     * @param id the user's id
     * @return void
     */
    @RequestMapping(method = RequestMethod.PUT,
                    value = "/users/updateuser/{id}")
    // take request body, turn into User instance and pass to addUser()
    public ResponseEntity<Void> updateUser(@RequestBody final User user,
                                           @PathVariable final long id) {
        // POST body should contain object being sent
        User existingUser = userService.getUser(id);
        if (existingUser == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.updateUser(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    /**
     * Deletes a user.
     * @param id the user id
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE,
                    value = "/users/deleteuser/{id}")
    //@PathVariable indicates use of wildcard above
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
