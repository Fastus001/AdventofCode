package com.karczmarzyk.advent2016.day13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazeSolverTest {
    MazeSolver solver;

    MazeGenerator generator;

    @BeforeEach
    void setUp() {
        generator= new MazeGenerator( 10,10 );
        solver = new MazeSolver( generator.getMaze(),
                                 new MazeSolver.Pair(1,1),
                                 new MazeSolver.Pair(4,7) );
    }

    @Test
    void showMazeAfterInitialization(){
        solver.showMaze();
    }

    @Test
    void start() {
        int numberOfMoves = solver.start();


        assertEquals( 11, numberOfMoves);
        solver.showMaze();
    }

    @Test
    void scanMaze() {
        solver.start();
        solver.showMaze();
    }

    @Test
    void partOne(){
        MazeGenerator gen = new MazeGenerator( 45,1352 );
        MazeSolver partOne = new MazeSolver( gen.getMaze(), new MazeSolver.Pair( 1,1 ),
                                             new MazeSolver.Pair( 39,31 ));

        int result = partOne.start();

        assertEquals( 90,result );
    }

    @Test
    void partTwo(){
        MazeGenerator gen = new MazeGenerator( 45,1352 );
        MazeSolver partOne = new MazeSolver( gen.getMaze(), new MazeSolver.Pair( 1,1 ),
                                             new MazeSolver.Pair( 39,31 ));

        partOne.start();

        long count = Arrays.stream( partOne.getMaze() )
                .flatMap( Stream::of )
                .filter( cube -> cube.getMove() <= 50 && cube.getMove()>0 )
                .count();
        int startLocation = 1;
        assertEquals( 135,count+startLocation );

    }
}