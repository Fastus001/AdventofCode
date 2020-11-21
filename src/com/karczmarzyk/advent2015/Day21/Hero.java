package com.karczmarzyk.advent2015.Day21;

import java.util.List;

public class Hero {
    private final Item weapon;
    private int damage;
    private int defence;
    private int cost;

    public Hero(List<Item> equipment) {
        this.weapon = equipment.get(0);
        for(Item item:equipment)
        {
            damage += item.getDamage();
            defence += item.getArmour();
            cost += item.getCost();
        }
    }

    public boolean fightWithBoss()
    {
        Fight fight = new Fight(getDamage(),getDefence(),100);
        return fight.resultOfFight();
    }

    public String getWeaponName() {
        return weapon.toString();
    }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public int getCost() {
        return cost;
    }
}
