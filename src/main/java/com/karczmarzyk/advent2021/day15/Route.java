package com.karczmarzyk.advent2021.day15;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Route {
    private final List<Tile> route = new ArrayList<>();
    private Tile lastTile;
    private boolean isFinished = false;

    public Route(List<Tile> route) {
        route.forEach(r->this.route.add(new Tile(r.row, r.col, r.risk)));
    }

    public Optional<Route> addTile(Tile tile) {
        //twice encountered same tile, destroy this route
        if (route.contains(tile)) {
            return Optional.empty();
        }
        this.lastTile = tile;
        route.add(tile);
        return Optional.of(this);
    }

    public int getRiskLevel() {
        return this.route.stream().mapToInt(Tile::risk).sum();
    }

    record Tile(int row, int col, int risk){
    }
}
