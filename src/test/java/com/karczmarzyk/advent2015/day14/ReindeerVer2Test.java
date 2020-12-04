package com.karczmarzyk.advent2015.day14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReindeerVer2Test {

    @Test
    public void testClass()
    {
        ReindeerVer2 reindeerVer2 = new ReindeerVer2("Comet",14,10,127);
    }

    @Test
    public void testReindeerV2Distance()
    {
        ReindeerVer2 reindeerVer2 = new ReindeerVer2("Comet",14,10,127);
        reindeerVer2.addDistance(1);
        assertEquals(14,reindeerVer2.getDistance());
        reindeerVer2.addDistance(10);
        assertEquals(140,reindeerVer2.getDistance());
        reindeerVer2.addDistance(11);
        assertEquals(140,reindeerVer2.getDistance());
        reindeerVer2.addDistance(1000);
        assertEquals(1120,reindeerVer2.getDistance());
    }

    @Test
    public void testArrayShow()
    {
        ReindeerVer2 reindeerVer2 = new ReindeerVer2("Comet",14,10,127);
        reindeerVer2.addDistance(1000);
        assertEquals(1120,reindeerVer2.getDistance());
        reindeerVer2.showArray();
    }

}