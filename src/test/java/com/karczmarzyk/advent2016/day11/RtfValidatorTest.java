package com.karczmarzyk.advent2016.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RtfValidatorTest {
    Rtf rtf;
    Elevator elevator;

    @BeforeEach
    void setUp() {
        List<Chip> chipList = new ArrayList<>();
        setupAddItemsToList( chipList );
        elevator = Elevator.builder().floor( 1 ).build();
        rtf = new Rtf( chipList, elevator );
    }

    @Test
    void validateRtfShouldBeOk() {
        assertTrue( RtfValidator.validateRtf( rtf ));
    }

    @DisplayName( "second positive test, with two generator and one micro on same floor" )
    @Test
    void validateRtfShouldBeOk2() {

        assertTrue( RtfValidator.validateRtf( rtf ));
    }

    private void setupAddItemsToList(List<Chip> chipList) {
        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.GENERATOR ).floor( 4 ).build() );
        chipList.add( Chip.builder().name( "hydrogen" ).type( Type.MICROCHIP ).floor( 4 ).build() );
        chipList.add( Chip.builder().name( "lithium" ).type( Type.GENERATOR ).floor( 4 ).build() );
        chipList.add( Chip.builder().name( "lithium" ).type( Type.MICROCHIP ).floor( 4 ).build() );
    }


}
