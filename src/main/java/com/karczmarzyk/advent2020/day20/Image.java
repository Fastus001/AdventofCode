package com.karczmarzyk.advent2020.day20;

import java.util.List;
import java.util.stream.Collectors;

public class Image {
    public static final int SIZE = 12;
    private List<ImageTile> image;
    private final ImageTile initImageTile;

    public Image(List<ImageTile> image) {
        this.image = image;

        initImageTile = getImageById(2221);
        initImageTile.setLock( true );
    }

    public ImageTile getInitImageTile() {
        return initImageTile;
    }

    public List<ImageTile> findAdjacentTiles(ImageTile imageTile){
        List<ImageTile> collect = image.stream()
                .filter( iT -> imageTile.checkTile( iT.getTile() )==2 )
                .filter( iT-> !iT.isLock() )
                .collect( Collectors.toList() );

        System.out.println( "collect z "+ imageTile+ " = " + collect );
        collect.forEach( imageTile::joinTiles );
        return collect;
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
