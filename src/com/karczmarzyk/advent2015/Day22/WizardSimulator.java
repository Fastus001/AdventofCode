package com.karczmarzyk.advent2015.Day22;

import java.util.List;
import java.util.stream.Collectors;

public class WizardSimulator {

    private static List<String> getCombinationsOfSpells()
    {
        SpellCombinations spellCombinations = new SpellCombinations();
        spellCombinations.addFirstFive();
        spellCombinations.addNewSpells(  spellCombinations.addFirstFive(),8 );
        return spellCombinations.getFullList();
    }

    public static void main(String[] args) {

        List<String> combinations = WizardSimulator.getCombinationsOfSpells();
//        int minimum = combinations.stream()
//                .mapToInt( WizardSimulator::fightResult )
//                .filter( s -> s > 0 )
//                .min()
//                .orElse( -20 );

        List<String> collect = combinations.stream().map( WizardSimulator::fightResultString )
                .filter( s -> s.length()>1 )
                .collect( Collectors.toList() );
        for (int i = 0; i < 100; i++) {
            System.out.println( "collect = " + collect.get( i ) );
        }


        System.out.println( "combinations.size() = " + combinations.size() );
    }

    public static int fightResult(String spells)
    {
        Wizard wizard = new Wizard( 50,500 );
        Fight fight = new Fight( wizard );
        fight.setBossHP( 55 );
        fight.addSpellList( spells );
        return fight.fightResult();
    }

    public static String fightResultString(String spells)
    {
        Wizard wizard = new Wizard( 50,500 );
        Fight fight = new Fight( wizard );
        fight.setBossHP( 55 );
        fight.addSpellList( spells );
        if(fight.fightResult() > 0)
            return spells;
        else
            return "";
    }
}
