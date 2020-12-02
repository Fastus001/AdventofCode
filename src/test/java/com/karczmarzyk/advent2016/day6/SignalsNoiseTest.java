package com.karczmarzyk.advent2016.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignalsNoiseTest {

    @Test
    void getNextLine() {
        SignalsNoise noise = new SignalsNoise( "eedadn" );
        noise.getInput("src/main/resources/2016/day6/test.txt");
        String result = noise.getText();
        assertEquals( "easter",result );
    }

    @Test
    void getNextLineTaskPartOne() {
        SignalsNoise noise = new SignalsNoise( "jpnomsle");
        noise.getInput("src/main/resources/2016/day6/day6.txt");
        String result = noise.getText();
        //answer part 1 (max)
//        assertEquals( "tzstqsua",result );
        //answer part 2 (min)
        assertEquals( "myregdnr",result );
    }
}