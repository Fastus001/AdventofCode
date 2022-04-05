package com.karczmarzyk.advent2021.day15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RouteTest {

    Route route;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addTile() {
        route = new Route(new Route.Tile(0,0, 1),1);

        route = this.route.addTile(new Route.Tile(1, 0, 1));
        assertThat(route.getTotalRisk()).isEqualTo(2);

    }

}