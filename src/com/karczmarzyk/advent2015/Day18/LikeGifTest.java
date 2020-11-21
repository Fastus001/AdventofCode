package com.karczmarzyk.advent2015.Day18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LikeGifTest {
    private LikeGif likeGif;
    //test cases for the sample input
    @Test
    public void testInputAndCountLightsOn()
    {
        assertEquals(15,likeGif.numbersOfLights());
    }

    @Test
    public void testFieldsIsOnOrOff()
    {
        likeGif.showList();
        assertEquals(0,likeGif.checkFieldLighOn(0,0));
        assertEquals(1,likeGif.checkFieldLighOn(0,1));
        assertEquals(0,likeGif.checkFieldLighOn(0,2));
        assertEquals(1,likeGif.checkFieldLighOn(0,3));
        assertEquals(0,likeGif.checkFieldLighOn(0,4));
        assertEquals(1,likeGif.checkFieldLighOn(0,5));
        assertEquals(0,likeGif.checkFieldLighOn(5,5));
        assertEquals(0,likeGif.checkFieldLighOn(5,6));
        assertEquals(0,likeGif.checkFieldLighOn(6,6));
        assertEquals(0,likeGif.checkFieldLighOn(-1,6));
        assertEquals(0,likeGif.checkFieldLighOn(0,-1));
    }

    @Test
    public void testCountNeighborsLightOn()
    {
        assertEquals(1,likeGif.countNeighborsLightOn(0,0));
        assertEquals(3,likeGif.countNeighborsLightOn(0,2));
        assertEquals(2,likeGif.countNeighborsLightOn(0,3));
        assertEquals(4,likeGif.countNeighborsLightOn(0,4));
        assertEquals(1,likeGif.countNeighborsLightOn(5,5));
        assertEquals(0,likeGif.countNeighborsLightOn(-1,-1));
    }

    @Test
    public void testUpdateLights()
    {
        likeGif.showList();
        assertEquals(15,likeGif.numbersOfLights());
        likeGif.updateLights();
        assertEquals(11,likeGif.numbersOfLights());
        likeGif.showList();
        likeGif.updateLights();
        assertEquals(8,likeGif.numbersOfLights());
        likeGif.showList();

        likeGif.updateLights();
        assertEquals(4,likeGif.numbersOfLights());
        likeGif.showList();

        likeGif.updateLights();
        assertEquals(4,likeGif.numbersOfLights());
        likeGif.showList();
    }


    @BeforeEach
    public void initClassLikeGif()
    {
        likeGif = new LikeGif();
    }

}