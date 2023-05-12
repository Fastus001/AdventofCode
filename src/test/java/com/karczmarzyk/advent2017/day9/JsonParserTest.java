package com.karczmarzyk.advent2017.day9;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    @Test
    void cleanCanceled() {

        String cleanCanceled = JsonParser.cleanCanceled("{{<!>},{<!>},{<!>},{<a>}}");

        assertEquals("{{<},{<},{<},{<a>}}", cleanCanceled);
    }

    @Test
    void removeGarbage() {
        String result = JsonParser.removeGarbage("{{<},{<},{<},{<a>}}");
        String result2 = JsonParser.removeGarbage("{<a>,<a>,<a>,<a>}");

        assertEquals("{{}}",result);
        assertEquals("{,,,}",result2);
    }

    @Test
    void partOneTest() throws IOException {
        String input = Files.readString(Path.of("src/main/resources/2017/day9/input.txt"));

        String result = JsonParser.cleanCanceled(input);
        result = JsonParser.removeGarbage(result);

        //part one
        int sum = JsonParser.count(result);
        //part two
        int garbageCount = JsonParser.countGarbage();

        assertEquals(17537, sum);
        assertEquals(7539, garbageCount);
    }

    @Test
    void count() {
        int sum = JsonParser.count("{{{},{},{{}}}}");
        int sum2 = JsonParser.count("{{<!!>},{<!!>},{<!!>},{<!!>}}");

        assertEquals(16, sum);
        assertEquals(9, sum2);
    }
}
