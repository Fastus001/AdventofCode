package com.karczmarzyk.advent2021.day9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SmokeTest {

    @Test
    void computeRiskLevel() throws IOException {
        Smoke smoke = new Smoke(Files.readAllLines(Path.of("src/main/resources/2021/day9/test.txt")));

        int result = smoke.computeRiskLevel();
        int basinSizesLargest = smoke.getBasinSizesLargest();

        Assertions.assertThat(result).isEqualTo(15);
        Assertions.assertThat(basinSizesLargest).isEqualTo(1134);
    }

    @Test
    void computeRiskLevelPartOne() throws IOException {
        Smoke smoke = new Smoke(Files.readAllLines(Path.of("src/main/resources/2021/day9/input.txt")));

        int result = smoke.computeRiskLevel();
        int basinSizesLargest = smoke.getBasinSizesLargest();

        Assertions.assertThat(result).isEqualTo(436);
        Assertions.assertThat(basinSizesLargest).isEqualTo(1317792);
    }
}