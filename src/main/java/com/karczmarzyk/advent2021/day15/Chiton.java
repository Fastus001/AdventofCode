package com.karczmarzyk.advent2021.day15;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class Chiton {
    private int riskLevel = Integer.MAX_VALUE;
    private final int[][] maze;
    private final int rowSize;
    private final int columnSize;
    private List<Route> routes = new ArrayList<>();

    public Chiton(List<String> input) {
        rowSize = input.get(0).length();
        columnSize = input.size();

        maze = new int[rowSize][columnSize];

        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                maze[row][column] = Integer.parseInt(String.valueOf(input.get(row).charAt(column)));
            }
        }
        List<Route.Tile> routeList = new ArrayList<>();
        routeList.add(new Route.Tile(0, 0, maze[0][0]));
        Route firstRoute = new Route(routeList);
        firstRoute.setLastTile(new Route.Tile(0, 0, maze[0][0]));
        routes.add(firstRoute);
    }

    public void makeMove() {
        routes = routes.stream().flatMap(route -> generateMoves(route).stream())
                .collect(Collectors.toList());


    }

    public List<Route> generateMoves(Route route) {
        Route.Tile lastTile = route.getLastTile();
        int row = lastTile.row();
        int col = lastTile.col();
        Optional<Route.Tile> tile = getRouteTile(row + 1, col);
        Optional<Route.Tile> tile1 = getRouteTile(row - 1, col);
        Optional<Route.Tile> tile2 = getRouteTile(row, col + 1);
        Optional<Route.Tile> tile3 = getRouteTile(row, col - 1);

        List<Route.Tile> tiles = Stream.of(tile, tile1, tile2, tile3)
                .filter(Optional::isPresent)
                .map(Optional::get).toList();

        List<Route> newRoutes = new ArrayList<>();
        tiles.forEach(t -> {
            Route tempRoute = new Route(route.getRoute());
            Optional<Route> routeOptional = tempRoute.addTile(t);
            routeOptional.ifPresent(newRoutes::add);
        });

        return newRoutes;
    }

    public Optional<Route.Tile> getRouteTile(int row, int col) {
        if (row < 0 || col < 0 || row >= rowSize || col >= columnSize) {
            return Optional.empty();
        }
        return Optional.of(new Route.Tile(row, col, maze[row][col]));
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                sb.append(maze[row][column]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
