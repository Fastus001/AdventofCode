package com.karczmarzyk.advent2021.day15;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Route {
    private int totalRisk;
    private Tile lastTile;
    private boolean isFinished = false;

    public Route(Tile lastTile, int totalRisk) {
        this.lastTile = lastTile;
        this.totalRisk = totalRisk;
    }

    public Route addTile(Tile tile) {
        this.lastTile = tile;
        this.totalRisk += tile.risk;
        return this;
    }

    record Tile(int row, int col, int risk){
    }
}
