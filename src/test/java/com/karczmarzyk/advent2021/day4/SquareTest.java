package com.karczmarzyk.advent2021.day4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class SquareTest {


    @BeforeEach
    void setUp() {

    }

    @Test
    void isRowOrColFull() throws IOException {
        BingoUtil util = new BingoUtil(Files.readAllLines(Path.of("src/main/resources/2021/day4/test.txt")));

        int bingoResult = util.getBingoResult();

        Assertions.assertThat(bingoResult).isEqualTo(4512);
    }

    @Test
    void partOne() throws IOException {
        BingoUtil util = new BingoUtil(Files.readAllLines(Path.of("src/main/resources/2021/day4/input.txt")));

        int bingoResult = util.getBingoResult();

        Assertions.assertThat(bingoResult).isEqualTo(69579);
    }

    @Test
    void partTwoTestCase() throws IOException {
        BingoUtil util = new BingoUtil(Files.readAllLines(Path.of("src/main/resources/2021/day4/test.txt")));

        int bingoResult = util.getBingoLastResult();

        Assertions.assertThat(bingoResult).isEqualTo(1924);
    }

    @Test
    void partTwo() throws IOException {
        BingoUtil util = new BingoUtil(Files.readAllLines(Path.of("src/main/resources/2021/day4/input.txt")));

        int bingoResult = util.getBingoLastResult();

        Assertions.assertThat(bingoResult).isEqualTo(14877);
    }
}