package com.karczmarzyk.advent2015.Day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReindeerTest {
    @Test
    void testReindeerClass()
    {
        Reindeer reindeer = new Reindeer("Comet",14,10,127);
    }

    @Test
    void testTheDistanceTraveled()
    {
        Reindeer reindeer = new Reindeer("Comet",14,10,127);
        Reindeer dancer = new Reindeer("Dancer",16,11,162);
        assertEquals(14,reindeer.getDistance(1));
        assertEquals(140,reindeer.getDistance(10));
        assertEquals(140,reindeer.getDistance(11));
        assertEquals(1120,reindeer.getDistance(1000));
        assertEquals(1056,dancer.getDistance(1000));
    }

}