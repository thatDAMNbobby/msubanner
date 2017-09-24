package edu.msudenver.cs3250.group6.msubanner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
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
    public void testUpdateUserSuccess() throws Exception {
        User user = new User("Morty", "Smith");
        user.setId(1234);

        when(userService.getUser(user.getId())).thenReturn(user);
        doNothing().when(userService).updateUser(user);

        mockMvc.perform(put("/users/update/{id}", user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(user))).andExpect(status().isOk());

        verify(userService, times(1)).getUser(user.getId());
        verify(userService, times(1)).updateUser(user);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testUpdateUserFailure() throws Exception {
        User user = new User();
        when(userService.getUser(user.getId())).thenReturn(null);

        mockMvc.perform(put("/users/update/{id}", user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(asJsonString(user)))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).getUser(user.getId());
        verifyNoMoreInteractions(userService);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
