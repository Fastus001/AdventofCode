package com.karczmarzyk.advent2015.day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellCombinationsTest {
    private SpellCombinations sC;

    @BeforeEach
    void setup()
    {
        sC = new SpellCombinations();
    }

    @Test
    @DisplayName( "Add new spells to one spell." )
    void testAddNewSpells()
    {
        sC.addNewSpells( sC.addFirstFive(), 1 );

        sC.show();
        assertAll( ()-> assertEquals( "Magic Missile", sC.getFullListIndex( 0 ).get( 0 )),
                   ()->assertEquals( 27, sC.getFullListSize()));
    }
}