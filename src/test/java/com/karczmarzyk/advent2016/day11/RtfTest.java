package com.karczmarzyk.advent2016.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RtfTest {
    Rtf rtf;
    Elevator elevatorFloorOne;

    @BeforeEach
    void setUp() {
        List<Chip> chipList = new ArrayList<>();
        setupAddItemsToList( chipList );
        elevatorFloorOne = Elevator.builder().floor( 1 ).build();
        rtf = new Rtf( chipList, elevatorFloorOne );
    }

    @Test
    void getCurrentItems() {
        List<Chip> items = rtf.itemsFromCurrentFloor( rtf.getMChips());

        assertEquals( 2,items.size() );
    }


    @Test
    void executeUpTwoItemsButShouldBeNull() throws CloneNotSupportedException {
        List<Chip> items = new ArrayList<>();
        items.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        items.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 1 ).build() );
        Rtf rtf1 = new Rtf( items,elevatorFloorOne );

        Rtf resultOfExecute = rtf1.executeNextMove( items, true );

        assertNull( resultOfExecute );
    }

    @Test
    void executeOneItemShouldBeOk() throws CloneNotSupportedException {
        List<Chip> items = new ArrayList<>();
        items.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        items.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 3 ).build() );
        Rtf rtf1 = new Rtf( items,elevatorFloorOne );


        Rtf resultOfExecute = rtf1.executeNextMove( rtf1.itemsFromCurrentFloor( rtf1.getMChips() ), true );

        assertNotNull( resultOfExecute );
        assertEquals( 2,resultOfExecute.getMChips().get( 0 ).getFloor() );
    }

    private void setupAddItemsToList(List<Chip> chipList) {
        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.GENERATOR ).floor( 2 ).build() );
        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 3 ).build() );
        chipList.add( Chip.builder().name( "lithium" ).type( Type.MICROCHIP ).floor( 1 ).build() );
    }

}