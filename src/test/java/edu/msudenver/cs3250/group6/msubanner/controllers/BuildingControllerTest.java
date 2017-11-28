/*package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class BuildingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private BuildingService buildingServiceMock;

    //Add WebApplicationContext field here

    //The setUp() method is omitted.

    @Test
    public void findAll_ShouldAddBuildingEntriesToModelAndRenderBuildingListView() throws Exception {
        Building first = new BuildingBuilder()
                .id(1L)
                .description("Lorem ipsum")
                .title("Foo")
                .build();

        Building second = new BuildingBuilder()
                .id(2L)
                .description("Lorem ipsum")
                .title("Bar")
                .build();

        when(buildingServiceMock.findAll()).thenReturn(Arrays.asList(first, second));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("building/list"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/building/list.jsp"))
                .andExpect(model().attribute("buildings", hasSize(2)))
                .andExpect(model().attribute("buildings", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("description", is("Lorem ipsum")),
                                hasProperty("title", is("Foo"))
                        )
                )))
                .andExpect(model().attribute("buildings", hasItem(
                        allOf(
                                hasProperty("id", is(2L)),
                                hasProperty("description", is("Lorem ipsum")),
                                hasProperty("title", is("Bar"))
                        )
                )));

        verify(buildingServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(buildingServiceMock);
    }*/