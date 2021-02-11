package com.karczmarzyk.advent2016.day13;

import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Setter
public class MazeSolver {
    private int MOVE = 0;
    private Cube[][] maze;
    private Pair start;
    private Pair end;

    public MazeSolver(Cube[][] maze, Pair start, Pair end) {
        this.maze = maze;
        this.start = start;
        this.end = end;
        maze[start.x][start.y].setTile( 'S' );
        maze[end.x][end.y].setTile( 'E' );
    }

    public MazeSolver(Cube[][] maze) {
        this.maze = maze;
    }

    public void showMaze() {
        for (Cube[] cubes : maze) {
            for (int y = 0; y < maze.length; y++) {
                System.out.print( cubes[y].getTile() );
            }
            System.out.println();
        }
    }

    public void scanMaze(){
        MOVE++;
        List<Cube> collect = Arrays.stream( maze )
                .flatMap( Stream::of )
                .filter( cube -> cube.getTile() == 'M' )
                .collect( Collectors.toList() );

        collect.forEach( cube -> setMoves( cube.getRow(),cube.getCol() ) );
        if(maze[end.x][end.y].getMove()==0){
            scanMaze();
        }
    }

    public int start() {
        MOVE++;
        int x = start.getX();
        int y = start.getY();
        setMoves( x, y );
        scanMaze();

        return maze[end.x][end.y].getMove();
    }

    private void setMoves(int x, int y) {
        setMoveOnCube( x - 1, y );
        setMoveOnCube( x + 1, y );
        setMoveOnCube( x, y - 1 );
        setMoveOnCube( x, y + 1 );
    }

    public void setMoveOnCube(int row, int col) {
        if ( row >= 0 && row < maze.length && col >= 0 && col < maze[0].length ) {
            Cube cube = maze[row][col];
            if ( cube.isEmpty() ) {
                cube.setTile( 'M' );
                cube.setMove( MOVE );
            }
            else if ( cube.getTile() == 'E' || (cube.getTile() >= 48 && cube.getTile()< 56) ) {
                cube.setMove( MOVE );
            }
        }
    }

    public Cube[][] getMaze() {
        return maze;
    }

    public static class Pair {
        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
