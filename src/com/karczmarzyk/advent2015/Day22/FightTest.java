package com.karczmarzyk.advent2015.Day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        fight.castSpell( "Shield" );
        assertEquals( 6,fight.getShieldRounds() );
    }

    @Test
    void shouldTimerBeWhenCheckEffect()
    {
        fight.castSpell( "Shield" );
        fight.checkEffects();
        assertEquals( 5,fight.getShieldRounds());
    }

    @Test
    void shouldTimerBeZeroWhenCheckEffectAfterSixRounds()
    {
        fight.castSpell( "Shield" );
        for (int i = 0; i < 6; i++) {
            fight.checkEffects();
        }
        assertEquals( 0,fight.getShieldRounds());
    }

    @Test
    void testPoison()
    {
        fight.castSpell( "Poison" );
        fight.checkEffects();
        assertEquals( 10,fight.getBossHP());
    }

    @Test
    void testPoisonAfterSixRounds()
    {
        fight.castSpell( "Poison" );
        fight.setBossHP( 19 );
        for (int i = 0; i < 6; i++) {
            fight.checkEffects();
        }
        assertEquals( 1,fight.getBossHP());
    }

    @Test
    void testRecharge()
    {
        fight.castSpell( "Recharge" );
        fight.checkEffects();
        assertEquals( 122, fight.getWizardManaPool() );
    }

    @Test
    void testAddSpellList()
    {
        fight.addSpellList(Arrays.asList( "Magic Missile","Magic Missile" ));
        assertEquals( "Magic Missile",fight.getSpell(0) );
        assertEquals( "Magic Missile",fight.getSpell(1) );
    }

    @Test
    void testOnePlayerRound()
    {
        fight.addSpellList( Arrays.asList("Magic Missile","Magic Missile" ));
        fight.playerRound();
        assertEquals( 9,fight.getBossHP() );
        fight.playerRound();
        fight.playerRound();
        assertTrue( fight.playerRound());
        assertFalse( fight.playerRound());
        assertFalse( fight.playerRound());
    }

    @Test
    void testBossRound()
    {
        assertTrue( fight.bossRound());
        assertFalse( fight.bossRound());
    }


    @Test
    void testFight()
    {
        Wizard wizard2 = new Wizard( 10,250 );
        Fight fight2 = new Fight( wizard2 );
        fight2.addSpellList( Arrays.asList("Poison","Magic Missile" ));
        assertEquals( 226,fight2.fightResult());
        assertEquals( 0,fight2.getBossHP() );
        assertEquals( 2,fight2.getWizardHp() );
    }

    @Test
    void testFight2()
    {
        Wizard wizard2 = new Wizard( 10,250 );
        Fight fight2 = new Fight( wizard2 );
        fight2.setBossHP( 14 );
        fight2.addSpellList( Arrays.asList( "Recharge","Shield","Drain","Poison","Magic Missile" ) );
        assertEquals( 641,fight2.fightResult());
        assertEquals( -1,fight2.getBossHP() );
        assertEquals( 1,fight2.getWizardHp() );
    }

    @Test
    @DisplayName( "Test konkretnego przypadku" )
    void testFight3()
    {
        Wizard wizard2 = new Wizard( 50,500 );
        Fight fight2 = new Fight( wizard2 );
        fight2.setBossHP( 55 );
        fight2.addSpellList( Arrays.asList( "Poison","Drain","Recharge","Poison","Shield","Recharge","Poison","Drain" ) );
        assertEquals( -1,fight2.fightResult());
        assertEquals( 17,fight2.getBossHP() );
        assertEquals( 11,fight2.getWizardHp() );
    }




}






























