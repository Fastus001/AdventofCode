package com.karczmarzyk.advent2016.day13;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cube implements Cloneable{
    private char tile;
    private char original;
    private int move = 0;
    private int row;
    private int col;

    public Cube(char tile, int row, int col) {
        this.tile = tile;
        this.row = row;
        this.col = col;
        this.original = tile;
    }

    public void reset(){
        tile  = original;
        move = 0;
    }

    public boolean isEmpty() {
        return tile == '.';
    }

    public boolean hasMove() {
        return move != 0;
    }

}
