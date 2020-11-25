package com.karczmarzyk.advent2015.Day22;

import java.util.List;

public class WizardSimulator {

    private static List<List<String>> getCombinationsOfSpells()
    {
        SpellCombinations spellCombinations = new SpellCombinations();
        spellCombinations.addFirstFive();
        spellCombinations.addNewSpells(  spellCombinations.addFirstFive(),8 );
        return spellCombinations.getFullList();
    }

    public static void main(String[] args) {

        List<List<String>> combinations = WizardSimulator.getCombinationsOfSpells();
        int minimum = combinations.stream()
                .mapToInt( WizardSimulator::fight )
                .filter( s -> s > 0 )
                .min()
                .orElse( -20 );
        System.out.println( "minimum = " + minimum );
    }

    public static int fight(List<String> spells)
    {
        Wizard wizard = new Wizard( 50,500 );
        Fight fight = new Fight( wizard );
        fight.setBossHP( 55 );
        fight.addSpellList( spells );
        return fight.fightResult();
    }

}
