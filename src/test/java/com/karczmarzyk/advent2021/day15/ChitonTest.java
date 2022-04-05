package com.karczmarzyk.advent2021.day15;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class ChitonTest {

    @Test
    void testToString() throws IOException {
        Chiton chiton = new Chiton(Files.readAllLines(Path.of("src/main/resources/2021/day15/test.txt")));


        System.out.println(chiton);
    }


    @Test
    void makeMove() throws IOException {
        Chiton chiton = new Chiton(Files.readAllLines(Path.of("src/main/resources/2021/day15/test.txt")));

        while (chiton.getRoutes().size() > 0) {
            chiton.makeMove();
        }

        assertThat(chiton.getRiskLevel()).isEqualTo(40);
    }

    @Test
    void partOne() throws IOException {
        Chiton chiton = new Chiton(Files.readAllLines(Path.of("src/main/resources/2021/day15/input.txt")));

        while (chiton.getRoutes().size() > 0) {
            chiton.makeMove();
        }

        assertThat(chiton.getRiskLevel()).isEqualTo(366);
    }

    @Test
    void generateMoves() throws IOException {
        Chiton chiton = new Chiton(Files.readAllLines(Path.of("src/main/resources/2021/day15/test.txt")));

        List<Route> routes = chiton.generateMoves(chiton.getRoutes().get(0));

        assertThat(routes.size()).isEqualTo(2);

        routes = chiton.generateMoves(routes.get(0));

        assertThat(routes.size()).isEqualTo(2);

        routes = chiton.generateMoves(new Route(new Route.Tile(9, 9, 1), 45));

        //
        assertThat(routes.size()).isEqualTo(1);
        assertThat(routes.get(0).isFinished()).isTrue();
    }

    @Test
    void getRouteTile() throws IOException {
        Chiton chiton = new Chiton(Files.readAllLines(Path.of("src/main/resources/2021/day15/test.txt")));

        Optional<Route.Tile> routeTile = chiton.getRouteTile(0, 0);
        assertThat(routeTile).isNotEmpty();
        assertThat(routeTile.get().risk()).isEqualTo(1);

        routeTile = chiton.getRouteTile(-1, 0);
        assertThat(routeTile).isEmpty();

        routeTile = chiton.getRouteTile(10, 0);
        assertThat(routeTile).isEmpty();

        routeTile = chiton.getRouteTile(9, 9);
        assertThat(routeTile).isNotEmpty();
        assertThat(routeTile.get().risk()).isEqualTo(1);
    }
}