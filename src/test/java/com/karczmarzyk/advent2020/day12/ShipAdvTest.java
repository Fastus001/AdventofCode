package com.karczmarzyk.advent2020.day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipAdvTest {
    ShipAdv shipAdv;

    @BeforeEach
    void setUp() {
        shipAdv = new ShipAdv();
    }

    @Test
    void changeDirection() {
    }

    @Test
    void move() {
        shipAdv.move("F",10);
        System.out.println("shipAdv.getEastWestDistance() = " + shipAdv.getEastWestDistance());
        System.out.println("shipAdv.getSouthNorthDistance() = " + shipAdv.getSouthNorthDistance());
        shipAdv.move("N",3);
        shipAdv.move("F",7);
        shipAdv.move("R",90);
        shipAdv.move("F",11);
        assertEquals(286,shipAdv.getShipLocation());
    }

    @Test
    void moveForward() {
        shipAdv.moveForward(10);
        assertEquals(110,shipAdv.getShipLocation());
    }
}