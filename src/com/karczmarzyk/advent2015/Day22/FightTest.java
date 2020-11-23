package com.karczmarzyk.advent2015.Day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {
    private Wizard wizard;
    private Fight fight;

    @BeforeEach
    void setup()
    {
        wizard = new Wizard( 13,250 );
        fight = new Fight( wizard );
    }

    @Test
    void testCastSpellMagicMissile()
    {
        fight.castSpell( "Magic Missile" );
        assertEquals( 9,fight.getBossHP() );
    }

    @Test
    void testCastSpellDrain()
    {
        fight.castSpell( "Drain" );
        assertEquals( 11,fight.getBossHP() );
        assertEquals( 15,wizard.getHP() );
    }

}