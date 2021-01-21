package com.karczmarzyk.advent2016.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataConverterTest {
    DataConverter converter;

    @BeforeEach
    void setUp() throws IOException {
        converter = new DataConverter();
        converter.setInputList( Files.readAllLines(
                Path.of( "src/main/resources/2016/day10/test.txt" )));
    }


    @Test
    void getBots() {
        List<Bot> botList = converter.getBotList();

        for (Bot bot : botList) {
            System.out.println(bot);
        }
        assertEquals( 3, botList.size() );
    }

    @Test
    void getValues() {
        List<String> values = converter.getValues();


        assertEquals( "value 5 goes to bot 2",values.get( 0 ) );
    }
}