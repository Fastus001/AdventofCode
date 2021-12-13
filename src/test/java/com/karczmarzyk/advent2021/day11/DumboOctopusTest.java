package com.karczmarzyk.advent2021.day11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DumboOctopusTest {

    @Test
    void testMethod() throws IOException {
        DumboOctopus dOc = new DumboOctopus(Files.readAllLines(Path.of("src/main/resources/2021/day11/test.txt")));
        for (int i = 0; i < 100; i++) {
            dOc.round();
        }

        int counter = dOc.getCounter();

        Assertions.assertThat(counter).isEqualTo(1656);
    }

    @Test
    void partOne() throws IOException {
        DumboOctopus dOc = new DumboOctopus(Files.readAllLines(Path.of("src/main/resources/2021/day11/input.txt")));
        for (int i = 0; i < 100; i++) {
            dOc.round();
        }

        int counter = dOc.getCounter();

        Assertions.assertThat(counter).isEqualTo(1649);
    }

    @Test
    void partTwo() throws IOException {
        DumboOctopus dOc = new DumboOctopus(Files.readAllLines(Path.of("src/main/resources/2021/day11/input.txt")));
        int round = 0;
        for (int i = 1; i < 350; i++) {
            int round1 = dOc.round();
            if(round1 == 100){
                round = i;
                break;
            }
        }
        Assertions.assertThat(round).isEqualTo(256);
    }
}