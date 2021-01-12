package com.karczmarzyk.advent2020.day22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    Game game;
    Game gameOne;

    @BeforeEach
    void setGame() throws IOException {
        game = new Game();
        game.addPlayerDecks( "src/main/resources/2020/day22/test.txt");
        gameOne = new Game();
        gameOne.addPlayerDecks( "src/main/resources/2020/day22/input.txt");
    }

    @Test
    void addPlayerDeck() {

        assertAll( ()->assertEquals( 9,game.getOne().peek() ),
                   ()->assertEquals( 5,game.getTwo().peek() ));
    }

    @Test
    void round() {
        while (!game.getOne().isEmpty() && !game.getTwo().isEmpty()){
            game.round();
        }

        System.out.println( "game.getOne() = " + game.getTwo());

        assertEquals( 3,game.getTwo().peek());
    }

    @Test
    void getResult() {
        while (!game.getOne().isEmpty() && !game.getTwo().isEmpty()){
            game.round();
        }

        assertEquals( 306,game.getResult() );
    }

    @Test
    void getResultPartOne() {
        while (!gameOne.getOne().isEmpty() && !gameOne.getTwo().isEmpty()){
            gameOne.round();
        }

        assertEquals( 33561,gameOne.getResult() );
    }
}