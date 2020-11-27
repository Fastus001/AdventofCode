package com.karczmarzyk.advent2015.day21;

public class Item {
    private final String name;
    private final int cost;
    private final int damage;
    private final int armour;

    public Item(String name, int cost, int damage, int armour) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.armour = armour;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmour() {
        return armour;
    }
}
