package edu.msudenver.cs3250.group6.msubanner.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomControllerTest {

    @Autowired
    public RoomController controller;

    @Test
    public void testContextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllRooms() {
        ModelAndView mav = controller.getAllRooms();
        assertThat("rooms".equals(mav));
    }

    @Test
    public void testGetRoom() {
        ModelAndView mav = controller.getRoom("54564");
        assertThat("rooms".equals(mav));
    }

    @Test
    public void testUpdateRoom() {
        ModelAndView mav = controller.updateRoom(1,1,new Building("Test building"),"54564");
        assertThat("showroom".equals(mav));
    }

    @Test
    public void testAddRoom() {
        ModelAndView mav = controller.addRoom(1,1,new Building("Test Building"));
        assertThat("rooms".equals(mav));
    }

    @Test
    public void testEditRoom() {
        ModelAndView mav = controller.editRoom("54564");
        assertThat("editroomform".equals(mav));
    }

    @Test
    public void testAddRoomForm() {
        ModelAndView mav = controller.addRoomForm();
        assertThat("addroomform".equals(mav));
    }

    @Test
    public void testDeleteRoomRedirect() {
        ModelAndView mav = controller.deleteRoomRedirect("54564");
        assertThat("rooms".equals(mav));
    }

    @Test
    public void testDeleteRoom() {
        controller.deleteRoom("54564");
        assertThat(true);
    }



}