package com.karczmarzyk.advent2015.Day22;

import java.util.ArrayList;
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
        }else{
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
        checkEffects();
        if(bossHP < 1)
            return false;
        return wizard.receiveDamage(bossDMG);
    }
    //false - boss lose or end of mana
    public boolean playerRound()
    {
        //TODO - part two only change!!!
        wizard.takeOneDamage();
        if(wizard.getHP()<1)
            return false;
        checkEffects();
        if(bossHP < 1)
            return false;
        if(spellCounter == spellBook.size()){
            wizard.setHpOnMinus();
            return false;
        }
        String spell = spellBook.get( spellCounter++ );
        if(wizard.isAbleToCastSpell(spell))
        {
            castSpell( spell);
        }else
            return false;
        return wizard.getManaPool() >= 0;
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
            wizard.addMana();
        }
    }

    private void checkPoisonEffect() {
        if(poisonEffect>0) {
            bossHP -=3;
                --poisonEffect;
            }
        }

    private void checkShieldEffect()
    {
        if(shieldEffect>0) {
            --shieldEffect;
            if ( shieldEffect == 0 ) {
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
