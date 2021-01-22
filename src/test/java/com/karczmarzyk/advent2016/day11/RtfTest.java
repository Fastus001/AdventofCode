package com.karczmarzyk.advent2016.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RtfTest {
    Rtf rtf;

    @BeforeEach
    void setUp() {
        List<Chip> chipList = new ArrayList<>();
        addToList( chipList );
        rtf = new Rtf( chipList, Elevator.builder().floor( 1 ).build() );
    }

    @Test
    void getCurrentItems() {
        List<Chip> items = rtf.getCurrentItems(rtf.getMChips());

        assertEquals( 2,items.size() );
    }

    private void addToList(List<Chip> chipList) {
        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.GENERATOR ).floor( 2 ).build() );
        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "lithium" ).type( Type.MICROCHIP ).floor( 1 ).build() );
    }

    @Test
    void executeUpTwoItems() {
        List<Chip> items = rtf.getCurrentItems( rtf.getMChips());

        Rtf execute = rtf.execute( items,true );

        assertEquals( 2,execute.getMChips().get( 3 ).getFloor() );
        assertEquals( 2,execute.getElevator().getFloor() );
        assertEquals( 1,execute.getMOVE() );
        assertEquals( 1,rtf.getMChips().get( 3).getFloor() );
        assertEquals( 1,rtf.getElevator().getFloor() );
        assertEquals( 0,rtf.getMOVE() );
    }

    @Test
    void executeUpTwoItemsButShouldBeNull() {
        List<Chip> items = new ArrayList<>();
        items.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        items.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 1 ).build() );

        Rtf resultOfExecute = rtf.execute( items,true );

        assertNull( resultOfExecute );
    }
}