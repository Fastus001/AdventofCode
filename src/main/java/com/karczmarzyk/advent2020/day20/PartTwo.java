package com.karczmarzyk.advent2020.day20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {
    public static final Pattern LINE_ONE = Pattern.compile( ".{18}#." );
    public static final Pattern LINE_TWO = Pattern.compile( "#.{4}##.{4}##.{4}###" );
    public static final Pattern LINE_THREE = Pattern.compile( ".#..#..#..#..#..#.{3}" );

    public static void main(String[] args) throws IOException {
        JigSaw jigSaw = new JigSaw( "src/main/resources/2020/day20/input.txt" );
        Image image = new Image( jigSaw.getImageTiles() );
        image.sortTiles();

        List<String> list = new ArrayList<>();
        list.add( "tile:00001" );
        for (int i = 0; i < 12; i++) {
            list.addAll( image.getOneImageLineWithoutBorderAndGaps( i));
        }
        Tile big = new Tile( list );
        big.rotateLeft();


        int counter = matchMonster( big.getAllRows() );
        int finalResult = big.getHashTileNumber()-(counter*15);
        System.out.println( "finalResult = " + finalResult );

    }

    private static int matchMonster(List<String> allRows) {
        int counter = 0;
        for (int row = 0; row < allRows.size(); row++) {
            Matcher two = LINE_TWO.matcher( allRows.get( row ) );
            while (two.find()){
                int twoStart = two.start();
                Matcher three = LINE_THREE.matcher( allRows.get( row+1 ).substring( twoStart ) );
                while (three.find()) {
                    int threeStart = three.start();
                    if(threeStart==0){
                        Matcher one = LINE_ONE.matcher( allRows.get( row-1 ).substring( twoStart ) );
                        while (one.find()){
                            int oneStart = one.start();
                            if(oneStart==0){
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }
}

