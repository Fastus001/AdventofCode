package com.karczmarzyk.advent2021.day13;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FoldMachineTest {

    @Test
    void foldInstruction() throws IOException {
        FoldMachine foldMachine = new FoldMachine(Files.readAllLines(Path.of("src/main/resources/2021/day13/test.txt")));

        int dots = foldMachine.foldInstruction("fold along y=7");
        int dotsTwo = foldMachine.foldInstruction("fold along x=5");

        Assertions.assertThat(dots).isEqualTo(17);
        Assertions.assertThat(dotsTwo).isEqualTo(16);
    }

    @Test
    void partOne() throws IOException {
        FoldMachine foldMachine = new FoldMachine(Files.readAllLines(Path.of("src/main/resources/2021/day13/input.txt")));

        int dots = foldMachine.foldInstruction("fold along x=655");

        Assertions.assertThat(dots).isEqualTo(735);
    }

    @Test
    void partTwo() throws IOException {
        FoldMachine foldMachine = new FoldMachine(Files.readAllLines(Path.of("src/main/resources/2021/day13/input.txt")));

        foldMachine.foldPaper();

//        UFRZKAUZ;
    }
}