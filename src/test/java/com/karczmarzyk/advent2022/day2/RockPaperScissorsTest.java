package com.karczmarzyk.advent2022.day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


class RockPaperScissorsTest {


    @Test
    void testCase() throws IOException {
        RockPaperScissors rps = new RockPaperScissors(Files.readAllLines(Path.of("src/main/resources/2022/day2/day2-2022test.txt")));

        Assertions.assertThat(rps.getTotalScore()).isEqualTo(15);
    }

    @Test
    void testPartOne() throws IOException {
        RockPaperScissors rps = new RockPaperScissors(Files.readAllLines(Path.of("src/main/resources/2022/day2/day2-2022.txt")));

        Assertions.assertThat(rps.getTotalScore()).isEqualTo(13268);
    }

    @Test
    void testCasePartTwo() throws IOException {
        RockPaperScissors rps = new RockPaperScissors(Files.readAllLines(Path.of("src/main/resources/2022/day2/day2-2022test.txt")));

        Assertions.assertThat(rps.getTotalScorePartTwo()).isEqualTo(12);
    }

    @Test
    void testPartTwo() throws IOException {
        RockPaperScissors rps = new RockPaperScissors(Files.readAllLines(Path.of("src/main/resources/2022/day2/day2-2022.txt")));

        Assertions.assertThat(rps.getTotalScorePartTwo()).isEqualTo(15508);
    }

}
