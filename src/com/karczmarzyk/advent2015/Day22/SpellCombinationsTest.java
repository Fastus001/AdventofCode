package com.karczmarzyk.advent2015.Day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpellCombinationsTest {
    private SpellCombinations sC;
    private List<StringBuilder> list;

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
        list.add( new StringBuilder("Magic Missile") );

       sC.addNewSpells( list, 1 );


        assertAll( ()-> assertEquals( "Magic Missile,Magic Missile", sC.getFullListIndex( 0 ).toString() ),
                   ()->assertEquals( 5, sC.getFullListSize()));
    }


    @Test
    @DisplayName( "Add new spells to five spells in List" )
    void testAddNewSpellsToFiveSpels()
    {

        sC.addNewSpells( sC.addFirstFive(), 1);


        assertAll( ()-> assertEquals( "Magic Missile,Magic Missile", sC.getFullListIndex( 0 ).toString() ),
                   ()-> assertEquals( "Recharge,Recharge", sC.getFullListIndex( sC.getFullListSize()- 1 ).toString() ),
                   ()->assertEquals( 25,sC.getFullListSize()));
    }

    @Test
    void shouldSizeBeAfterThreeSteps()
    {
        sC.addNewSpells( sC.addFirstFive(), 3);

        assertEquals( 775,sC.getFullListSize() );
    }



}