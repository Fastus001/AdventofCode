package com.karczmarzyk.advent2021.day8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class DigitTest {

    @Test
    void initTest() {
        Digit digit = new Digit("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        long number = digit.getNumber();

        Assertions.assertThat(number).isEqualTo(5353);
    }

    @Test
    void initTest2() {
        Digit digit = new Digit("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");

        long number = digit.getNumber();

        Assertions.assertThat(number).isEqualTo(8394L);
    }

    @Test
    void initTest3() {
        Digit digit = new Digit("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc");

        long number = digit.getNumber();

        Assertions.assertThat(number).isEqualTo(9781L);
    }

    @Test
    void testPartTwo() throws IOException {
        long result = Files.readAllLines(Path.of("src/main/resources/2021/day8/teest.txt")).stream()
                .map(Digit::new)
                .mapToLong(Digit::getNumber)
                .sum();

        Assertions.assertThat(result).isEqualTo(61229L);
    }

    @Test
    void partTwo() throws IOException {
        long result = Files.readAllLines(Path.of("src/main/resources/2021/day8/input.txt")).stream()
                .map(Digit::new)
                .mapToLong(Digit::getNumber)
                .sum();

        Assertions.assertThat(result).isEqualTo(987553L);
    }
}