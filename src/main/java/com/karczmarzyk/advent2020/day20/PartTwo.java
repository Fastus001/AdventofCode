package com.karczmarzyk.advent2020.day20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartTwo {
    private static Image image;

    public static void main(String[] args) throws IOException {
        JigSaw jigSaw = new JigSaw( "src/main/resources/2020/day20/input.txt" );
        image = new Image( jigSaw.getImageTiles() );

        List<ImageTile> adjacentTiles = image.findAdjacentTiles( image.getImageById( 2221 ) );

        List<ImageTile> imageTiles = adjacentTileList( adjacentTiles );

        while (imageTiles.size()>0){
            imageTiles = adjacentTileList( imageTiles );
        }


        int num = 3011;
        System.out.println( "this = " + image.getImageById( num ) );
        System.out.println( "up = " + image.getImageById( num ).getUp() );
        System.out.println( "down = " + image.getImageById( num ).getDown() );
        System.out.println( "left = " + image.getImageById( num ).getLeft() );
        System.out.println( "right = " + image.getImageById( num ).getRight() );
        System.out.println( "Pair = " + image.getImageById( num ).getXy() );
        long count = image.getImage().stream().filter( i -> !i.isLock() ).count();
        System.out.println( "count = " + count );

    }

    public static List<ImageTile> adjacentTileList(List<ImageTile> input){
        List<ImageTile> temp = new ArrayList<>();
        for(ImageTile it:input){
            temp.addAll( image.findAdjacentTiles( it ) );
        }
        return temp;
    }



}
