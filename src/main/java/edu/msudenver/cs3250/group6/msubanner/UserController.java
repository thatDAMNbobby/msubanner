package edu.msudenver.cs3250.group6.msubanner;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Gets the list of all users.
     * @return the list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            // We did this so we could see a user when the server was started
            // to make sure the get request worked.
            // remove if un-needed
            users.add(new User("Database is", "Actually Empty"));
            //return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
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
     * * @param user the user to be added
     * @return the new user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
    // the @RequestBody param was not working, so we re tooled this to use a Map<String, String>
    // This gives us key/value pairs from the form which we can use to build/validate a user object
    public ResponseEntity<User> addUser(@RequestParam final Map<String, String> body) {
//        Old code
//        System.out.println("Adding user. id: " + user.getId() + "name : " + user.getFirstName() + " " + user.getLastName() );
//        // POST body should contain object being sent
//        //userService.addUser(user);
//        return new ResponseEntity<User>(user, HttpStatus.CREATED);

        // Debug stuff to print out the content of the form that was received
        System.out.println("Post request hit /users/adduser containing " + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        // Create and validate a user object
        User user = new User();
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        // TBD: Sanitize input! - remove any html tags to prevent XSS attacks

        // Set name fields
        user.setFirstName(firstName);
        user.setLastName(lastName);
        // id field is populated when added to the database

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
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
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
