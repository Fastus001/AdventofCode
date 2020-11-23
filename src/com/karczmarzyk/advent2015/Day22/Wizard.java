package com.karczmarzyk.advent2015.Day22;

public class Wizard {
    private int manaSpent = 0;
    private int mana;
    private int health;
    private int armour = 0;

    public Wizard(int health,int mana) {
        this.health = health;
        this.mana = mana;
    }

    public int castMagicMissile()
    {
        manaSpent +=53;
        mana -=53;
        return 4;
    }

    public int castDrain()
    {
        manaSpent +=73;
        mana -=73;
        health +=2;
        return 2;
    }

    public int castShield()
    {
        manaSpent +=113;
        mana -=113;
        armour = 7;
        return 6;
    }

    public int castPoison()
    {
        manaSpent +=173;
        mana -=173;
        //TODO - damage 3pts each round
        return 6;
    }

    public int castRecharge()
    {
        manaSpent +=229;
        //TODO - recharge of mana
        return 5;
    }

    public int getHP() {
        return health;
    }
}
