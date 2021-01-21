package com.karczmarzyk.advent2016.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BotFactoryTest {
    BotFactory factory;


    @BeforeEach
    void setUp() throws IOException {
        DataConverter converter = new DataConverter();
        converter.setInputList( Files.readAllLines(
                Path.of( "src/main/resources/2016/day10/input.txt" )));
        factory = new BotFactory();
        factory.addBots( converter.getBotList() );
        factory.addValues( converter.getValues() );
    }

    @Test
    void addBots() {
    }

    @Test
    void addValues() {
    }

    @Test
    void addValue() {
    }

    @Test
    void checkPartOne() {
        factory.checkBots();

        String botNumber = factory.getBotNumber( 61, 17 );

        assertEquals( "bot 147",botNumber );
    }
}