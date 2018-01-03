package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.entities.User;
import edu.msudenver.cs3250.group6.msubanner.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        ModelAndView ret = controller.getAllUsers();
        assertThat("users".equals(ret));
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User();
        user.setFirstName("Peter");
        user.setLastName("Pettigrew");
        user.setId("747372");

        ModelAndView mav = controller.getUser("747372");
        assertThat("user".equals(mav));
    }

    @Test
    public void testAddUser() throws Exception {
        Map<String, String> body = new HashMap<>();
        body.put("firstName", "Donald");
        body.put("lastName", "Drumpf");

        ModelAndView mav = controller.addUser(body);
        assertThat("users".equals(mav));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setFirstName("Peter");
        user.setLastName("Pettigrew");
        user.setId("747372");

        String someFirstName = "Prehensile";
        String someLastName = "Tail";

        userRepository.save(user);

        ModelAndView mav = controller.updateUser(someFirstName, someLastName, "747372");

        assertThat(mav.getViewName().equals("showuser"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = new User();
        user.setFirstName("Peter");
        user.setLastName("Pettigrew");
        user.setId("747372");

        userRepository.save(user);

        ResponseEntity<Void> voidMsg = controller.deleteUser("747372");

        assertThat("user".equals(voidMsg));
    }

    @Test
    public void testDeleteUserVoid() throws Exception {
        controller.deleteUser("808080");
        ResponseEntity<Void> voidMsg2 = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        assertThat("user".equals(voidMsg2));
    }

    @Test
    public void testDeleteUserRedirect() throws Exception {
        User user = new User();
        user.setFirstName("Peter");
        user.setLastName("Pettigrew");
        user.setId("747372");

        userRepository.save(user);

        ModelAndView mav = controller.deleteUserRedirect("747372");

        assertThat("users".equals(mav));
    }

    @Test
    public void testAddUserForm() throws Exception {
        ModelAndView mav = controller.addUserForm();
        assertThat("adduserform".equals(mav));
    }

    @Test
    public void editUser() throws Exception {
        User user = new User();
        user.setFirstName("Peter");
        user.setLastName("Pettigrew");
        user.setId("747372");

        userRepository.save(user);

        ModelAndView mav = controller.editUser("747372");
        assertThat("edituserform".equals(mav));
    }

}
