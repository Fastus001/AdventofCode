package com.karczmarzyk.advent2020.day20;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {

    public static void main(String[] args) throws IOException {
        JigSaw jigSaw = new JigSaw( "src/main/resources/2020/day20/input.txt" );
        ImageTile imageTile;

        List<Tile> tiles = jigSaw.getTiles();
        List<ImageTile> imageTiles = new ArrayList<>();
        for(Tile tile:tiles) {
            imageTiles.add( new ImageTile( tile ));
        }
        for (int i = 0; i < imageTiles.size(); i++) {
            imageTile = imageTiles.get( i );
            for (int j = 0; j < tiles.size(); j++) {
                if ( i != j ){
                    int i1 = imageTile.checkTile( tiles.get( j ));
                    imageTile.setNumber( i1 );
                }
            }
        }
        List<Integer> collect = imageTiles.stream()
                .filter( iT -> iT.getNumber() == 4 )
                .mapToInt( iT -> iT.getTile().getIdNumber() )
                .boxed()
                .collect( Collectors.toList() );

        long count = imageTiles.stream()
                .filter( iT -> iT.getNumber() == 8 )
                .count();

        System.out.println( "count = " + count );

        System.out.println( "collect = " + collect );
    }
}
