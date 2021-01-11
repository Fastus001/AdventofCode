package com.karczmarzyk.advent2020.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Image {
    private static List<ImageTile> image;

    public Image(List<ImageTile> image) {
        Image.image = image;

        ImageTile initImageTile = getImageById( 2221 );
        initImageTile.setLock( true );
        initImageTile.setXy( new Pair( 11, 11) );
    }

    public List<String> getOneImageLineWithoutBorderAndGaps(int row){
        List<ImageTile> line = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            line.add( getImageByXY( row, i ));
        }
        List<List<String>> rowsWithoutBorders = line.stream()
                .map( iT -> iT.getTile().getAllRowsWithoutBorders() )
                .collect( Collectors.toList() );

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            var sb = new StringBuilder();
            for (int j = 0; j < 12; j++) {
              sb.append( rowsWithoutBorders.get( j ).get( i ) );
            }
            result.add( sb.toString() );
        }
        return result;

    }

    public void sortTiles(){
        List<ImageTile> adjacentTiles = findAdjacentTiles( getImageById( 2221 ) );

        List<ImageTile> imageTiles = adjacentTileList( adjacentTiles );

        while (imageTiles.size()>0){
            imageTiles = adjacentTileList( imageTiles );
        }
    }

    public static List<ImageTile> findAdjacentTiles(ImageTile imageTile){
        List<ImageTile> collect = image.stream()
                .filter( iT -> imageTile.checkTile( iT.getTile() )==2 )
                .filter( iT-> !iT.isLock() )
                .collect( Collectors.toList() );

        collect.forEach( imageTile::joinTiles );
        return collect;
    }

    public static List<ImageTile> adjacentTileList(List<ImageTile> input){
        List<ImageTile> temp = new ArrayList<>();
        for(ImageTile it:input){
            temp.addAll( findAdjacentTiles( it ) );
        }
        return temp;
    }

    public ImageTile getImageById(int id){
        return image.stream()
                .filter( i -> i.getTile().getIdNumber() == id )
                .findFirst()
                .orElseThrow();
    }
    public ImageTile getImageByXY(int row, int col){
        return image.stream()
                .filter( i -> i.getXy().getRow()==row && i.getXy().getCol()==col )
                .findFirst()
                .orElseThrow();
    }
}
