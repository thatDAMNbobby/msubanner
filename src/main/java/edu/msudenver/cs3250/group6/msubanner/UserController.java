package edu.msudenver.cs3250.group6.msubanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for the User class.
 * @author Group 6
 */

@RestController
public class UserController {

    /** The user service.*/
    @Autowired
    private UserService userService;


//    @GetMapping("/user")
//    public String userForm(Model model) {
//        model.addAttribute("user", new User());
//        return "user";
//    }
//
//    @PostMapping("/user")
//    public String userSubmit(@ModelAttribute User user) {
//        return "result";
//    }

    /**
     * Gets the list of all users.
     * @return the list of all users
     */
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Gets a user by id number.
     * @param id the user id
     * @return the user
     */
    @RequestMapping("/users/getuser/{id}")
    //@PathVariable indicates use of {id} wildcard above
    public User getUser(@PathVariable final long id) {
    return userService.getUser(id);
    }

    /**
     * Adds a user.
     * @param user the user to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
    // take request body, turn into User instance and pass to addUser()
    public void addUser(@RequestBody final User user) {
        // POST body should contain object being sent
        userService.addUser(user);
    }

    /**
     * Updates a user.
     * @param user the user to be updated
     * @param id the user's id
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/users/updateuser/{id}")
    // take request body, turn into User instance and pass to addUser()
    public void updateUser(@RequestBody final User user,
                           @PathVariable final long id) {
        // POST body should contain object being sent
        userService.updateUser(id, user);
    }

    /**
     * Deletes a user.
     * @param id the user's id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/deleteuser/{id}")
    public void deleteUser(@PathVariable final long id) {
        //@PathVariable indicates use of wildcard above
        userService.deleteUser(id);
    }
}
