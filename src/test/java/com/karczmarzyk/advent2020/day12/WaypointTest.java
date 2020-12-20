package com.karczmarzyk.advent2020.day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaypointTest {
    Waypoint waypoint;

    @BeforeEach
    void setUp() {
        waypoint = new Waypoint();
    }

    @Test
    void changeWaypoint() {
        waypoint.changeWaypoint("N",3);
        assertEquals(4,waypoint.getNorth());
    }

    @Test
    void rotate() {
        waypoint.changeWaypoint("N",3);
        waypoint.rotate(90, true);
        assertEquals(4,waypoint.getEast());
        assertEquals(10,waypoint.getSouth());
    }
}