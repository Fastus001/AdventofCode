package com.karczmarzyk.advent2016.day13;

public class MazeGenerator {
    private final int size;
    private final int favoriteNumber;
    private Cube[][] maze;

    public MazeGenerator(int size, int favoriteNumber) {
        this.size = size;
        this.favoriteNumber = favoriteNumber;
        createMaze();
    }

    private void createMaze() {
        maze = new Cube[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                //switched x with y, because I use raw and columns not coordinate axis!!
                maze[x][y] = new Cube( generate( y, x ), x, y );
            }
        }
    }

    public Cube[][] getMaze() {
        return maze;
    }

    public char generate(int x, int y) {
        int number = (x * x) + (3 * x) + (2 * x * y) + y + (y * y) + favoriteNumber;
        String binaryString = Integer.toBinaryString( number );
        int counter = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if ( binaryString.charAt( i ) == '1' ) {
                counter++;
            }
        }
        return counter % 2 == 0 ? '.' : '#';
    }


}
