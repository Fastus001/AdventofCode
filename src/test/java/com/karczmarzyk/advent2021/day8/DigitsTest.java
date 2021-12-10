package com.karczmarzyk.advent2021.day8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DigitsTest {

    @Test
    void countDigits() throws IOException {
        Digits digits = new Digits(Files.readAllLines(Path.of("src/main/resources/2021/day8/teest.txt")));

        long countDigits = digits.countDigits();

        Assertions.assertThat(countDigits).isEqualTo(26);
    }

    @Test
    void patOne() throws IOException {
        Digits digits = new Digits(Files.readAllLines(Path.of("src/main/resources/2021/day8/input.txt")));

        long countDigits = digits.countDigits();

        Assertions.assertThat(countDigits).isEqualTo(261L);
    }
}