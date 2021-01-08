package com.karczmarzyk.advent2020.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Tile {
    public static final Pattern NUM = Pattern.compile( "(\\d+)" );
    public static final int SIZE = 10;
    private int idNumber = 0;
    private char[][] box = new char[SIZE][SIZE];

    public Tile(List<String> idNumber) {
        String s = NUM.matcher( idNumber.get( 0 ) )
                .results()
                .map( MatchResult::group )
                .findFirst()
                .orElseThrow();
//
        this.idNumber = Integer.parseInt( s);
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                box[i][j] = idNumber.get( i+1 ).charAt( j );
            }
        }
    }


    public void rotateLeft(){
        List<String> temp = new ArrayList<>();
        for (int i = SIZE-1; i >= 0; i--) {
            temp.add( getColumn( i ,false) );
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                box[i][j] = temp.get( i ).charAt( j );
            }
        }

    }

    public List<String> getAllSides(){
        List<String> temp = new ArrayList<>();
        temp.add( getRow( 0, false ) );
        temp.add( getRow( 9 ,false) );
        temp.add( getColumn( 0,false ) );
        temp.add( getColumn( 9,false ) );
        temp.add( getRow( 0, true ) );
        temp.add( getRow( 9 ,true) );
        temp.add( getColumn( 0,true ) );
        temp.add( getColumn( 9,true ) );
        return temp;
    }

    public String getColumn(int col, boolean reversed){
        var sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append( box[i][col]);
        }
        return reversed?sb.reverse().toString():sb.toString();
    }

    public String getRow(int row, boolean reversed){
        var sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append( box[row][i]);
        }
        return reversed?sb.reverse().toString():sb.toString();
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

    public int getIdNumber() {
        return idNumber;
    }

    public void showTile(){
        System.out.println( idNumber );
        for (char[] chars : box) {
            for (int j = 0; j < box.length; j++) {
                System.out.print( chars[j] );
            }
            System.out.println();
        }
    }
}
