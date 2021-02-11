package com.karczmarzyk.advent2016.day24;

import com.karczmarzyk.advent2016.day13.Cube;
import com.karczmarzyk.advent2016.day13.MazeGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeSolverAdvTest {
    MazeSolverAdv solverAdv;


    @BeforeEach
    void setUp() throws IOException {
        MazeGenerator generator = new MazeGenerator(
                Files.readAllLines( Path.of( "src/main/resources/2016/day24/input.txt" ) ) );
        solverAdv = new MazeSolverAdv( generator.getMaze() );
    }

    @Test
    void setStart() {
        Cube cube = solverAdv.setStart( '0' );

        assertEquals( '0', cube.getTile() );
        assertEquals( 5, cube.getRow() );
        assertEquals( 135, cube.getCol() );
    }


    @Test
    void testFirstSearch(){
        char start = '0';
        char end = '1';
        solverAdv.setStart( start );
        solverAdv.setEnd( end );
        solverAdv.start();
        int result = solverAdv.start();


        assertEquals( 26,result );
    }
}