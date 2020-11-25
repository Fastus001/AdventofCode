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
        return 6;
    }

    public int castRecharge()
    {
        manaSpent +=229;
        mana -=229;
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

    public boolean receiveDamage(int bossDMG) {
        health -= bossDMG-armour;
        return health > 0;
    }

    public int getSpentMana() {
        return manaSpent;
    }

    public void takeOneDamage() {
        health -=1;
    }

    public boolean isAbleToCastSpell(String spell) {
        switch (spell)
        {
            case "Magic Missile": return mana>=53 ;
            case "Drain":return mana >=73;
            case "Shield":return mana>= 113;
            case "Poison": return mana >=173;
            case "Recharge": return mana >= 229;
            default:
                return false;
        }
    }

    public void setHpOnMinus() {
        health = -1;
    }
}
