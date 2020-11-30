package com.karczmarzyk.advent2015.day21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day21Test {
    @Test
    public void testClassItem()
    {
        Item item = new Item("Dagger",8,0,0);
    }

    @Test
    public void testInputDataItems()
    {
        EquipmentPermutations simulator = new EquipmentPermutations();
        simulator.getItemsData();
        assertEquals(16, simulator.getSizeOfItems());
    }

    @Test
    public void testPermutationsOfWeaponsWithOrWithoutArmour()
    {
        EquipmentPermutations simulator = new EquipmentPermutations();
        simulator.getItemsData();
        assertEquals(30, simulator.getPermutationsOfWeaponSize());
    }

    @Test
    public void testPermutationsOfRings()
    {
        EquipmentPermutations simulator = new EquipmentPermutations();
        simulator.getItemsData();
        assertEquals(21, simulator.getPermutationsOfRingsSize());
    }

    @Test
    public void getAllPermutations()
    {
        EquipmentPermutations simulator = new EquipmentPermutations();
        simulator.getItemsData();

        assertEquals(660, simulator.getSizeOfAllPermutations());
    }

    @Test
    public void testHeroClass()
    {
        EquipmentPermutations simulator = new EquipmentPermutations();
        simulator.getItemsData();
        Hero hero = new Hero(simulator.getItemListAt(0));
        assertEquals("Dagger", hero.getWeaponName());
    }

    @Test
    public void testDamageDefenceAndTotalCost()
    {
        EquipmentPermutations simulator = new EquipmentPermutations();
        simulator.getItemsData();
        Hero hero = new Hero(simulator.getItemListAt(0));
        assertEquals(4, hero.getDamage());
        assertEquals(0, hero.getDefence());
        assertEquals(8, hero.getCost());
    }

    @Test
    public void testFightClass()
    {
        Fight fight = new Fight(5,5,8);
        assertTrue(fight.resultOfFight());
    }

}