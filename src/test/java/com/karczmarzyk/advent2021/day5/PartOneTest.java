package com.karczmarzyk.advent2021.day5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PartOneTest {

    @Test
    void getResult() throws IOException {
        PartOne partOne = new PartOne(Files.readAllLines(Path.of("src/main/resources/2021/day5/test.txt")));

        long result = partOne.getResult();

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void getResultPartOne() throws IOException {
        PartOne partOne = new PartOne(Files.readAllLines(Path.of("src/main/resources/2021/day5/input.txt")));

        long result = partOne.getResult();

        Assertions.assertThat(result).isEqualTo(8350L);
    }

    @Test
    void getTestResultPartTwo() throws IOException {
        PartOne partOne = new PartOne(Files.readAllLines(Path.of("src/main/resources/2021/day5/test.txt")));

        long result = partOne.getResultPartTwo();

        Assertions.assertThat(result).isEqualTo(12);
    }

    @Test
    void getResultPartOTwo() throws IOException {
        PartOne partOne = new PartOne(Files.readAllLines(Path.of("src/main/resources/2021/day5/input.txt")));

        long result = partOne.getResultPartTwo();

        Assertions.assertThat(result).isEqualTo(19374L);
    }
}