package com.karczmarzyk.advent2020.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Image {
    public static final int SIZE = 12;
    private static List<ImageTile> image;

    public Image(List<ImageTile> image) {
        this.image = image;

        ImageTile initImageTile = getImageById( 2221 );
        initImageTile.setLock( true );
        initImageTile.setXy( new Pair( 11, 11) );
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

    public List<ImageTile> getImage() {
        return image;
    }

    public ImageTile getImageById(int id){
        return image.stream()
                .filter( i -> i.getTile().getIdNumber() == id )
                .findFirst()
                .orElseThrow();
    }
}
