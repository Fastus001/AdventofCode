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
//        System.out.println("Player casts Magic Missile, dealing 4 damage.");
        return 4;
    }

    public int castDrain()
    {
        manaSpent +=73;
        mana -=73;
        health +=2;
//        System.out.println("Player casts Drain, dealing 2 damage, and healing 2 hit points.");
        return 2;
    }

    public int castShield()
    {
        manaSpent +=113;
        mana -=113;
        armour = 7;
//        System.out.println("Player casts Shield, increasing armor by 7.");
        return 6;
    }

    public int castPoison()
    {
        manaSpent +=173;
        mana -=173;
//        System.out.println("Player casts Poison.");
        return 6;
    }

    public int castRecharge()
    {
        manaSpent +=229;
        mana -=229;
//        System.out.println("Player casts Recharge.");
        return 5;
    }

    public int getHP() {
        return health;
    }

    public void setArmourZero() {
        this.armour = 0;
    }

    public void addMana() {
        mana +=101;
    }

    public int getManaPool() {
        return mana;
    }

    public void show() {
//        System.out.printf("- Player has %d hit points, %d armor, %d mana",health,armour,mana);
    }

    public boolean receiveDamage(int bossDMG) {
        int dmg = bossDMG-armour;
//        if(armour==0)
//            System.out.println("Boss attacks for 8 damage!");
//        else
//            System.out.printf("Boss attacks for 8-%d=%s damage!\n",armour,dmg);
        health -= dmg;
        return health > 0;
    }

    public int getSpentMana() {
        return manaSpent;
    }
}
