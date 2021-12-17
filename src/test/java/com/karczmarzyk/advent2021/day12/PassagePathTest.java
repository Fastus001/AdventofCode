package com.karczmarzyk.advent2021.day12;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class PassagePathTest {

    @Test
    void testConstructor() throws IOException {
        PassagePath pp = new PassagePath(Files.readAllLines(Path.of("src/main/resources/2021/day12/test1.txt")));
        while (pp.getSizeOfRoutes()!=0){
            pp.compute();
        }

        assertThat(pp.numberOfRoutes()).isEqualTo(226);
    }

    @Test
    void partOne() throws IOException {
        PassagePath pp = new PassagePath(Files.readAllLines(Path.of("src/main/resources/2021/day12/input.txt")));
        while (pp.getSizeOfRoutes()!=0){
            pp.compute();
        }

        assertThat(pp.numberOfRoutes()).isEqualTo(3369);
    }
}