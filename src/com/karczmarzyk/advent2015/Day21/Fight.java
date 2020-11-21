package com.karczmarzyk.advent2015.Day21;

public class Fight {
    private int bossHP = 103;
    private final int heroDamage;
    private final int heroArmour;
    private int heroHP;

    public Fight(int heroDamage, int heroArmour, int heroHP) {
        this.heroDamage = heroDamage;
        this.heroArmour = heroArmour;
        this.heroHP = heroHP;
    }

    public boolean resultOfFight() {
        while(bossHP>0 | heroHP>0)
        {
            int bossArmour = 2;
            bossHP -= getDamage(heroDamage, bossArmour);
            if(bossHP<1)
                return true;
            int bossDamage = 9;
            heroHP -=getDamage(bossDamage,heroArmour);
            if(heroHP <1)
                return false;
        }
        return false;
    }

    private int getDamage(int dmg, int armour) {
        return Math.max(dmg - armour, 1);
    }
}
