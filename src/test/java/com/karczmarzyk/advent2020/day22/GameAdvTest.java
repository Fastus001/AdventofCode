package com.karczmarzyk.advent2020.day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameAdvTest {
    GameAdv adv;

    @BeforeEach
    void setUp() throws IOException {
        adv = new GameAdv();
        adv.addPlayerDecks( "src/main/resources/2020/day22/input.txt" );
    }

    @Test
    void round() {
        adv.result();
        assertEquals( 34594,adv.getResult() );
    }
}