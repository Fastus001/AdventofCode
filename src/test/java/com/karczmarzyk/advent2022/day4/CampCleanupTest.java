package com.karczmarzyk.advent2022.day4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class CampCleanupTest {

    @Test
    void getFullyContainedTestCase() throws IOException {
        CampCleanup cc = new CampCleanup(Files.readAllLines(Path.of("src/main/resources/2022/day4/day4-test.txt")));

        final int fullyContained = cc.getFullyContained();

        Assertions.assertThat(fullyContained).isEqualTo(2);
    }

    @Test
    void getFullyContained() throws IOException {
        CampCleanup cc = new CampCleanup(Files.readAllLines(Path.of("src/main/resources/2022/day4/day4-input.txt")));

        final int fullyContained = cc.getFullyContained();

        Assertions.assertThat(fullyContained).isEqualTo(509);
    }

    @Test
    void getFullyContainedTestCasePartTwo() throws IOException {
        CampCleanup cc = new CampCleanup(Files.readAllLines(Path.of("src/main/resources/2022/day4/day4-test.txt")));

        final int fullyContained = cc.getOverlapNumber();

        Assertions.assertThat(fullyContained).isEqualTo(4);
    }

    @Test
    void getFullyContainedPartTwo() throws IOException {
        CampCleanup cc = new CampCleanup(Files.readAllLines(Path.of("src/main/resources/2022/day4/day4-input.txt")));

        final int fullyContained = cc.getOverlapNumber();

        Assertions.assertThat(fullyContained).isEqualTo(870);
    }
}
