package com.karczmarzyk.advent2015.Day21;

public class Fight {
    private int bossDamage = 9;
    private int bossArmour = 2;
    private int bossHP = 103;
    private int heroDamage;
    private int heroArmour;
    private int heroHP;

    public Fight(int heroDamage, int heroArmour, int heroHP) {
        this.heroDamage = heroDamage;
        this.heroArmour = heroArmour;
        this.heroHP = heroHP;
    }

    public boolean resultOfFight() {
        while(bossHP>0 | heroHP>0)
        {
            bossHP -= getDamage(heroDamage,bossArmour);
//            System.out.println("bossHP = " + bossHP);
            if(bossHP<1)
                return true;
            heroHP -=getDamage(bossDamage,heroArmour);
//            System.out.println("heroHP = " + heroHP);
            if(heroHP <1)
                return false;
        }
        return false;
    }

    private int getDamage(int dmg, int armour) {
        if(dmg-armour < 1)
            return 1;
        else
            return dmg-armour;
    }
}
