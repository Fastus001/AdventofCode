package com.karczmarzyk.advent2020.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatsTest {
    Seats seats;

    @BeforeEach
    void setUp() {
        seats = new Seats( 10 );
        seats.populateGrid( InputStringLines.getInput( "src/main/resources/2020/day11/test.txt" ) );
    }

    @Test
    void populateGrid() {
        seats.show();
    }

    @Test
    void checkSeat() {
        seats.setSeatOn( 9,9 );
        seats.show();
        assertEquals( 0,seats.checkSeat( 0,0 ));
        assertEquals( 1,seats.checkSeat( 9,9 ));
    }

    @Test
    void shouldBeWhenOutOFBounds(){
        assertEquals( 0 ,seats.checkSeat( -1,5 ));
        assertEquals( 0 ,seats.checkSeat( 1,11 ));
    }


    @Test
    void getNumberOfOccupiedSeats() {
        assertEquals( 0,seats.getNumberOfOccupiedSeats( 0,0 ) );
    }

    @Test
    void getNumberOfOccupiedSeatsThree() {
        seats.setSeatOn( 0,0 );
        seats.setSeatOn( 1,0 );
        seats.setSeatOn( 1,1 );
        seats.show();
        assertEquals( 2,seats.getNumberOfOccupiedSeats( 2,0 ) );
    }


    @Test
    void getNumberOfOccupiedSeatsNine() {
        for (int i = 7; i < 10 ; i++) {
            for (int j = 4; j <7 ; j++) {
                seats.setSeatOn( i,j );
            }
        }
        seats.show();
        assertEquals( 8,seats.getNumberOfOccupiedSeats( 8,5 ) );
    }

    @Test
    void getNewGrid() {
        seats.setGrid( seats.getNewGrid());
        seats.setGrid( seats.getNewGrid());
        seats.setGrid( seats.getNewGrid());
        seats.setGrid( seats.getNewGrid());
        seats.setGrid( seats.getNewGrid());
        seats.setGrid( seats.getNewGrid());
        assertEquals( 37, seats.getOccupiedSeats() );
    }

    @Test
    void show() {
    }

    @Test
    void getSIZE() {
       
    }
}