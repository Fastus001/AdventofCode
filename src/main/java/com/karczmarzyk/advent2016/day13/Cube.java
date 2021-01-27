package com.karczmarzyk.advent2016.day13;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cube {
    private char tile;
    private int move = 0;
    private int row;
    private int col;

    public Cube(char tile, int row, int col) {
        this.tile = tile;
        this.row = row;
        this.col = col;
    }

    public boolean isEmpty() {
        return tile == '.';
    }

    public boolean hasMove() {
        return move != 0;
    }
}
