package com.karczmarzyk.advent2015.Day21;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EquipmentPermutations eq = new EquipmentPermutations();
        eq.getItemsData();
        List<Hero> listOfHeroes = new ArrayList<>();
        for (int i = 0; i < eq.getSizeOfAllPermutations(); i++) {
            listOfHeroes.add(new Hero(eq.getItemListAt(i)));
        }

        int minimumCostOfEq = listOfHeroes.stream()
                .filter(Hero::fightWithBoss)
                .mapToInt(Hero::getCost)
                .min()
                .orElse(-1);
        int maxCost = listOfHeroes.stream()
                .filter(hero -> !hero.fightWithBoss())
                .mapToInt(Hero::getCost)
                .max()
                .orElse(-1);
        System.out.println("minimumCostOfEq = " + minimumCostOfEq);
        System.out.println("maxCost = " + maxCost);
    }
}
