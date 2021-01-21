package com.karczmarzyk.advent2016.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

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
        factory.addValueInstructions( converter.getValues() );
    }

    @Test
    void checkPartTwo() {
        factory.checkBots();
        Map<String, Bot> botMap = factory.getBotMap();

        Bot bot88 = botMap.get( "bot 88" );
        Bot bot188 = botMap.get( "bot 188" );
        Bot bot116 = botMap.get( "bot 116" );

        int result = bot88.getValue( true ) * bot116.getValue( true ) * bot188.getValue( true );


        assertEquals( 55637,result );
    }

    @Test
    void checkPartOne() {
        factory.checkBots();

        String botNumber = factory.getBotName( 61, 17 );

        assertEquals( "bot 147",botNumber );
    }
}