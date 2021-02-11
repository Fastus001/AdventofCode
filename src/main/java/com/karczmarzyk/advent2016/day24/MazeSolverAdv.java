package com.karczmarzyk.advent2016.day24;

import com.karczmarzyk.advent2016.day13.Cube;
import com.karczmarzyk.advent2016.day13.MazeSolver;

import java.util.Arrays;
import java.util.stream.Stream;

public class MazeSolverAdv extends MazeSolver {

    public MazeSolverAdv(Cube[][] maze) {
        super( maze );
    }

    public Cube setStart(char number){
        Cube start = getCubeWithNumber( number );
        super.setStart( new MazeSolver.Pair( start.getRow(), start.getCol() ) );
        return start;
    }

    public void setEnd(char number){
        Cube end = getCubeWithNumber( number );
        super.setEnd( new MazeSolver.Pair( end.getRow(), end.getCol() ) );
    }

    @Override
    public int start() {
        resetAll();
        super.setMOVE( 0 );
        return super.start();
    }

    private void resetAll() {
        Arrays.stream( super.getMaze() )
                .flatMap( Stream::of )
                .forEach( Cube::reset );
    }

    public Cube getCubeWithNumber(char number) {
        return Arrays.stream( super.getMaze() )
                .flatMap( Stream::of )
                .filter( cube -> cube.getTile() == number )
                .findFirst()
                .orElseThrow();
    }
}
