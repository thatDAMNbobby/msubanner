package edu.msudenver.cs3250.group6.msubanner;

import edu.msudenver.cs3250.group6.msubanner.User;
import edu.msudenver.cs3250.group6.msubanner.UserController;
import edu.msudenver.cs3250.group6.msubanner.UserService;

import static edu.msudenver.cs3250.group6.msubanner.UserControllerTest.asJsonString;
import static org.hamcrest.Matchers.containsString;
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

public class GetUserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }
    @Test
    public void test_create_user_success() throws Exception {
        User user = new User("Jesus", "Torres");
        //user.setId(1);
        when(userService.getUser(user.getId())).thenReturn(user);
        doNothing().when(userService).addUser(user);

        mockMvc.perform(post("/users/adduser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user))).andExpect(status().isCreated());

        verify(userService, times(1)).addUser(user);
        verifyNoMoreInteractions(userService);
    }
}