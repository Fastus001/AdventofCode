package com.karczmarzyk.advent2015.Day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fight {
    private int bossHP = 13;
    private final int bossDMG = 8;
    private int shieldEffect = 0;
    private int poisonEffect = 0;
    private int rechargeEffect = 0;
    private Wizard wizard;
    private List<String> spellBook = new ArrayList<>();
    private int spellCounter = 0;

    public Fight(Wizard wizard) {
        this.wizard = wizard;
    }

    public int getBossHP() {
        return bossHP;
    }


    public void castSpell(String name)
    {
        System.out.println( "mana " + wizard.getManaPool() );
        switch (name)
        {
            case "Magic Missile": bossHP -= wizard.castMagicMissile() ;break;
            case "Drain": bossHP -= wizard.castDrain(); break;
            case "Shield":
                if(shieldEffect==0)
                    shieldEffect = wizard.castShield(); break;
            case "Poison":
                if(poisonEffect==0){
                    poisonEffect = wizard.castPoison();
                }
                break;
            case "Recharge":
                if ( rechargeEffect ==0 )
                    rechargeEffect = wizard.castRecharge();break;
            default:
                System.out.println("B³¹d!!"); break;
        }
    }


    public int fightResult()
    {
        boolean test = true;
        while(test)
        {
            test = playerRound();
            if(!test)
                break;
            test = bossRound();
            if(!test)
                break;
        }

        if(bossHP < 1) {
            return wizard.getSpentMana();
        }
//        }else if(wizard.getHP() <1)
//        {
//            return -1;
//        }
        else{
            return -1;
        }
    }

    public void addSpellList(List<String> spells)
    {
        spellBook = spells;
    }
//    true - fight goes on, false - boss or player lose
    public boolean bossRound()
    {
        System.out.println("\n-- Boss turn --");
        showContenders();
        checkEffects();
        if(bossHP < 1)
            return false;
        return wizard.receiveDamage(bossDMG);
    }
    //false - boss lose or end of mana
    public boolean playerRound()
    {
        System.out.println("\n-- Player turn --");
        wizard.takeOneDamage();
        if(wizard.getHP()<1)
            return false;
        showContenders();
        checkEffects();
        if(bossHP < 1)
            return false;

        castSpell( spellBook.get( spellCounter++ ));
        if(spellCounter == spellBook.size())
            spellCounter=0;
        return wizard.getManaPool() >= 0;
    }

    public void showContenders()
    {
        wizard.show();
        System.out.printf("\n- Boss has %d hit points\n",bossHP);
    }

    public void checkEffects()
    {
        checkShieldEffect();
        checkPoisonEffect();
        checkRechargeEffect();
    }

    private void checkRechargeEffect() {
        if(rechargeEffect > 0)
        {
            --rechargeEffect;
            System.out.println("Recharge provides 101 mana; its timer is now " + --rechargeEffect);
            wizard.addMana();
            if(rechargeEffect == 0)
                System.out.println("Recharge wears off.");
        }

    }

    private void checkPoisonEffect() {
        if(poisonEffect>0) {
            System.out.print("Poison deals 3 damage.");
            bossHP -=3;
            if(bossHP < 1) {
                System.out.println( "This kills the boss, and the player wins." );
            }else{
//                --poisonEffect;
                System.out.println(" its timer is now " + --poisonEffect + ".");
            }
            if ( poisonEffect == 0 ) {
                System.out.println( "Poison wears off." );
            }
        }
    }

    private void checkShieldEffect()
    {
        if(shieldEffect>0) {
//            --shieldEffect;
            System.out.println( "Shield's timer is now " + --shieldEffect );
            if ( shieldEffect == 0 ) {
                System.out.println( "Shield wears off, decreasing armor by 7." );
                wizard.setArmourZero();
            }
        }
    }

    public int getShieldRounds() {
        return shieldEffect;
    }

    public void setBossHP(int bossHP) {
        this.bossHP = bossHP;
    }

    public int getWizardManaPool() {
        return wizard.getManaPool();
    }

    public String getSpell(int i) {
        if(i == spellBook.size())
            i=0;
        return spellBook.get( i );
    }

    public int getWizardHp() {
        return wizard.getHP();
    }
}
