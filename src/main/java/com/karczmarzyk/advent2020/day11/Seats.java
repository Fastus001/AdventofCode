package com.karczmarzyk.advent2020.day11;

import java.util.List;

public class Seats {
    private final int SIZE;
    private char[][] grid;

    public Seats(int size) {
        this.SIZE = size;
        grid = new char[SIZE][SIZE];
    }

    public char[][] getNewGrid() {
        char [][] temp = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if(grid[row][col] =='L' && getNumberOfOccupiedSeats( row,col ) == 0){
                    temp[row][col] = '#';
                }else if(grid[row][col] =='#' && getNumberOfOccupiedSeats( row,col ) >= 4){
                    temp[row][col] = 'L';
                }else{
                    temp[row][col] = grid[row][col];
                }
            }
        }
        return temp;
    }

    public int checkSeat(int row, int col){
        if(row <0 || row>=SIZE || col<0 || col >=SIZE){
            return 0;
        }

        return grid[row][col] == '#'? 1:0;
    }


    public void setSeatOn(int row, int col){
        if(grid[row][col] != '.')
            grid[row][col] = '#';
    }

    public int getNumberOfOccupiedSeats(int row, int col){
        int counter = 0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <= col+1 ; j++) {
                    counter += checkSeat( i,j );
                }
            }
        return counter-checkSeat( row,col );
    }


    public void populateGrid(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get( i ).length(); j++) {
                grid[i][j] = list.get( i ).charAt( j );
            }
        }
    }

    public void show() {
        for (char[] chars : grid) {
            for (int g = 0; g < grid.length; g++) {
                System.out.print( chars[g] );
            }
            System.out.println();
        }
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public int getOccupiedSeats() {
        int count = 0;
        for (char[] chars : grid) {
            for (int g = 0; g < grid.length; g++) {
                if( chars[g] =='#' )
                    count++;
            }
        }
        return count;
    }
}
