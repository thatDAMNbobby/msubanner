package edu.msudenver.cs3250.group6.msubanner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * References:
 * www.bytestree.com/spring/restful-web-services-unit-testing-spring-boot/
 * memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/
 */

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testAddUserSuccess() throws Exception {
        User user = new User("Jesus", "Torres");

        when(userService.getUser(user.getId())).thenReturn(user);
        doNothing().when(userService).addUser(user);

        mockMvc.perform(post("/users/adduser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(user))).andExpect(status().isCreated());

        verify(userService, times(1)).addUser(user);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testUpdateUserSuccess() throws Exception {
        User user = new User("Morty", "Smith");

        when(userService.getUser(user.getId())).thenReturn(user);
        doNothing().when(userService).updateUser(user);

        mockMvc.perform(put("/users/updateuser/{id}", user.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(user))).andExpect(status().isOk());

        verify(userService, times(1)).getUser(user.getId());
        verify(userService, times(1)).updateUser(user);
        verifyNoMoreInteractions(userService);
    }

    // TODO: Fix this or test the right thing
    // should someone even be able to get to /users/updateuser/{id}
    // with an invalid id? Doesn't seem good.

    // @Test
    // public void testUpdateUserFailure() throws Exception {
    // User user = new User();
    // when(userService.getUser(user.getId())).thenReturn(null);
    //
    // mockMvc.perform(put("/users/updateuser/{id}", user.getId())
    // .contentType(MediaType.APPLICATION_JSON_UTF8)
    // .contentType(asJsonString(user)))
    // .andExpect(status().isNotFound());
    //
    // verify(userService, times(1)).getUser(user.getId());
    // verifyNoMoreInteractions(userService);
    // }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
