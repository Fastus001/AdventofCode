package com.karczmarzyk.advent2020.day20;

import java.util.List;

public class Tile {
    public static final int SIZE = 10;
    private String idNumber;
    private char[][] box = new char[SIZE][SIZE];

    public Tile(List<String> idNumber) {
        this.idNumber = idNumber.get( 0 );
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                box[i][j] = idNumber.get( i+1 ).charAt( j );
            }
        }
    }

    public String getColumn(int col){
        var sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append( box[i][col]);
        }
        return sb.toString();
    }

    public String getRow(int row){
        var sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append( box[row][i]);
        }
        return sb.toString();
    }

    public void flipHorizontally(){
        char[][] temp = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                temp[i][j] = box[i][SIZE-1-j];
            }
        }
        box = temp;
    }

    public void flipVertically(){
        char[][] temp = new char[SIZE][SIZE];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = box[temp.length-1-i];
        }
        box = temp;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void showTile(){
        System.out.println( idNumber );
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                System.out.print( box[i][j] );
            }
            System.out.println();
        }
    }
}
