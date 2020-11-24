package com.karczmarzyk.advent2015.Day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpellCombinationsTest {
    private SpellCombinations sC;
    private List<List<String>> list;

    @BeforeEach
    void setup()
    {
        sC = new SpellCombinations();
        list = new ArrayList<>();
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


//    @Test
//    @Disabled
//    @DisplayName( "Add new spells to five spells in List" )
//    void testAddNewSpellsToFiveSpels()
//    {
//
//        sC.addNewSpells( sC.addFirstFive(), 1);
//
//
//        assertAll( ()-> assertEquals( "Magic Missile,Magic Missile", sC.getFullListIndex( 0 ).toString() ),
//                   ()-> assertEquals( "Recharge,Recharge", sC.getFullListIndex( sC.getFullListSize()- 1 ).toString() ),
//                   ()->assertEquals( 25,sC.getFullListSize()));
//    }
//
//    @Test
//    @Disabled( )
//    void shouldSizeBeAfterThreeSteps()
//    {
//        sC.addNewSpells( sC.addFirstFive(), 3);
//
//        assertEquals( 775,sC.getFullListSize() );
//    }



}