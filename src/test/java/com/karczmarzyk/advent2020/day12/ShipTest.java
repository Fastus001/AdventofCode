package com.karczmarzyk.advent2020.day12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    Ship ship;

    @BeforeEach
    void setUp() {
        ship = new Ship();
    }

    @Test
    void changeDirection() {
        ship.changeDirection("R",90);
        assertEquals(90,ship.getDirection());
        ship.changeDirection("R",270);
        assertEquals(0,ship.getDirection());
    }

    @Test
    void changeDirectionLeft(){
        ship.changeDirection("L",90);
        ship.changeDirection("L",360);
        assertEquals(-90,ship.getDirection());
    }

    @Test
    void move() {
        ship.move("F",10);
        ship.move("N",3);
        ship.move("F",7);
        ship.move("R",90);
        ship.move("F",11);
        assertEquals(17,ship.getEastWest());
        assertEquals(8,ship.getSouthNorth());
        assertEquals(25,ship.getShipLocation());
    }
}