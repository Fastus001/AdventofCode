package com.karczmarzyk.advent2021.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class RouteTest {

    Route route;

    @BeforeEach
    void setUp() {
        List<Route.Tile> tiles = new ArrayList<>();
        tiles.add(new Route.Tile(0,0,1));
        tiles.add(new Route.Tile(1,0,1));
        tiles.add(new Route.Tile(1,1,3));
        tiles.add(new Route.Tile(1,2,8));
        route = new Route(tiles);
    }

    @Test
    void addTile() {
        Optional<Route> optRout = route.addTile(new Route.Tile(2, 2, 3));

        assertThat(optRout).isNotEmpty();

        Optional<Route> optionalRoute = route.addTile(new Route.Tile(2, 2, 3));
        assertThat(optionalRoute).isEmpty();
    }

    @Test
    void getRiskLevel() {
        int riskLevel = route.getRiskLevel();

        assertThat(riskLevel).isEqualTo(13);
    }
}