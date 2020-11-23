package com.karczmarzyk.advent2015.Day22;

public class Fight {
    private int bossHP = 13;
    private int bossDMG = 8;
    private int shieldEffect = 0;
    private int poisonEffect = 0;
    private int rechargeEffect = 0;
    private Wizard wizard;

    public Fight(Wizard wizard) {
        this.wizard = wizard;
    }

    public int getBossHP() {
        return bossHP;
    }


    public void castSpell(String name)
    {
        switch (name)
        {
            case "Magic Missile": bossHP -= wizard.castMagicMissile() ;break;
            case "Drain": bossHP -= wizard.castDrain(); break;
            case "Shield": shieldEffect = wizard.castShield(); break;
            case "Poison": poisonEffect = wizard.castPoison(); break;
            case "Recharge": rechargeEffect = wizard.castRecharge();break;
            default:
                System.out.println("B³¹d!!"); break;
        }
    }
}
