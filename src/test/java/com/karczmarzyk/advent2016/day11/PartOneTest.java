package com.karczmarzyk.advent2016.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PartOneTest {
    PartOne partOne;

    @BeforeEach
    void setUp() {
        List<Chip> chipList = new ArrayList<>();
        setupAddItemsToList( chipList );
        Elevator elevator = Elevator.builder().floor( 4 ).build();
        Rtf rtf = new Rtf( chipList, elevator);
        partOne = new PartOne( rtf.generatePossibleMoves() );
        }

    @Test
    void makeMove() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Runda---------- " + (i+1));
            partOne.makeMove();
        }

    }

    private void setupAddItemsToList(List<Chip> chipList) {
        chipList.add( Chip.builder().name( "PRomethium" ).type( Type.GENERATOR ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "PRomethium" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "elerium" ).type( Type.GENERATOR ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "elerium" ).type( Type.MICROCHIP ).floor( 1 ).build() );
        chipList.add( Chip.builder().name( "dilithium" ).type( Type.GENERATOR ).floor( 4 ).build() );
//        chipList.add( Chip.builder().name( "dilithium" ).type( Type.MICROCHIP ).floor( 1 ).build() );
//        chipList.add( Chip.builder().name( "CObalt" ).type( Type.GENERATOR ).floor( 2 ).build() );
//        chipList.add( Chip.builder().name( "CObalt" ).type( Type.MICROCHIP ).floor( 3 ).build() );
//        chipList.add( Chip.builder().name( "CUrium" ).type( Type.GENERATOR ).floor( 2 ).build() );
//        chipList.add( Chip.builder().name( "CUrium" ).type( Type.MICROCHIP ).floor( 3 ).build() );
//        chipList.add( Chip.builder().name( "RUthenium" ).type( Type.GENERATOR ).floor( 2 ).build() );
//        chipList.add( Chip.builder().name( "RUthenium" ).type( Type.MICROCHIP ).floor( 3 ).build() );
//        chipList.add( Chip.builder().name( "PLutonium" ).type( Type.GENERATOR ).floor( 2 ).build() );
//        chipList.add( Chip.builder().name( "PLutonium" ).type( Type.MICROCHIP ).floor( 3 ).build() );
    }


//    private void setupAddItemsToList(List<Chip> chipList) {
//        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.GENERATOR ).floor( 2 ).build() );
//        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 1 ).build() );
//        chipList.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 3 ).build() );
//        chipList.add( Chip.builder().name( "lithium" ).type( Type.MICROCHIP ).floor( 1 ).build() );
//    }
}