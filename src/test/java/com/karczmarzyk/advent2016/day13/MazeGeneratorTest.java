package com.karczmarzyk.advent2016.day13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeGeneratorTest {
    MazeGenerator mazeGenerator;

    @BeforeEach
    void setUp() {
        mazeGenerator = new MazeGenerator( 10,10 );
    }

    @Test
    void generate() {
        assertEquals( '.',mazeGenerator.generate( 0,0 ));
        assertEquals( '.',mazeGenerator.generate( 0,1 ));
        assertEquals( '#',mazeGenerator.generate( 1,0 ));
    }

    @Test
    void showMaze() throws IOException {
        MazeGenerator generator =
                new MazeGenerator( Files.readAllLines( Path.of( "src/main/resources/2016/day24/input.txt" ) ) );

        generator.showMaze();
    }
}