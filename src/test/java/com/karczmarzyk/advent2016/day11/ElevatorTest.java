package com.karczmarzyk.advent2016.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {
    Elevator elevator;
    Chip HM;

    @BeforeEach
    void setUp() {
        elevator = new Elevator();
        HM = new Chip( "hydrogen", Type.MICROCHIP, 1 );
        elevator.setFirst( HM );
        elevator.setFloor( 1 );
    }

    @Test
    void attacheSecondSameGeneratorAndChip() {
        Chip hg = Chip.builder()
                .name( "hydrogen" )
                .type( Type.GENERATOR )
                .floor( 1 ).build();

        assertTrue( elevator.attacheSecond( hg ) );
    }

    @Test
    void attacheSecondDifferentGeneratorAndChip() {
        Chip LG = Chip.builder()
                .name( "lithium" )
                .type( Type.GENERATOR )
                .floor( 1 ).build();

        assertFalse( elevator.attacheSecond( LG ) );
    }

    @Test
    void attacheSecondTwoMicrochips() {
        Chip LM = Chip.builder()
                .name( "lithium" )
                .type( Type.MICROCHIP )
                .floor( 1 ).build();

        assertTrue( elevator.attacheSecond( LM ) );
    }

    @Test
    void moveUp() {
        elevator.moveUp();

        assertEquals( 2,elevator.getFloor() );
        assertEquals( 2,elevator.getFirst().getFloor() );
    }

    @Test
    void moveDown() {
    }

    @Test
    void setSecond() {
        elevator.setSecond( HM );

        assertEquals("hydrogen",elevator.getSecond().getName());
    }
}