package com.karczmarzyk.advent2016.day13;

import java.util.List;

public class MazeGenerator {
    private int sizeX;
    private int sizeY;
    private int favoriteNumber;
    private Cube[][] maze;

    public MazeGenerator(int sizeX, int favoriteNumber) {
        this.sizeX = sizeX;
        this.favoriteNumber = favoriteNumber;
        createMaze();
    }

    public MazeGenerator(List<String> lines){
        sizeX = lines.get( 0 ).length();
        sizeY = lines.size();
        maze = new Cube[sizeY][sizeX];
        for (int row = 0; row < sizeY; row++) {
            for (int col = 0; col < sizeX; col++) {
                maze[row][col] = new Cube( lines.get( row ).charAt( col ), row, col );
            }
        }
    }

    private void createMaze() {
        maze = new Cube[sizeX][sizeX];
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeX; y++) {
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

    public void showMaze(){
        for (int row = 0; row < sizeY; row++) {
            for (int col = 0; col < sizeX; col++) {
                System.out.print(maze[row][col].getTile());
            }
            System.out.println();
        }
    }


}
