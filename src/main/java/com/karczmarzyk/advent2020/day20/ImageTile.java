package com.karczmarzyk.advent2020.day20;

import java.util.List;

public class ImageTile {
    private int number = 0;
    private final Tile tile;

    public ImageTile(Tile tile) {
        this.tile = tile;
    }

    public int checkTile(Tile tile){
        List<String> allSides = this.tile.getAllSides();
        int counter = 0;
        for (String  s:allSides){
            for(String x: tile.getAllSides()){
                if(s.equals( x )){
                    counter++;
                }
            }
        }
        return counter;
    }

    public void setNumber(int num){
        number +=num;
    }

    public int getNumber() {
        return number;
    }

    public Tile getTile() {
        return tile;
    }
}
