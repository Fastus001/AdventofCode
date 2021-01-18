package com.karczmarzyk.advent2020.day24;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tiles {
    private static final int SIZE = 106;
    private Map<Pair, Hex> tiles = new HashMap<>();
    private Map<Pair, Hex> temp = new HashMap<>();

    public Tiles() throws IOException {
        var lines = Files.readAllLines( Path.of( "src/main/resources/2020/day24/input.txt" ) );
        var collect = getCollect( lines );
        initEmptyTiles();

        for (String s : collect) {
            setUpTile( s );
        }
    }

    public long transform() {
        temp = new HashMap<>();
        tiles.forEach( ((pair, hex) -> checkAdjacentTiles( pair )) );
        tiles = new HashMap<>( temp );
        return tiles.values().stream().filter( Hex::isBlack ).count();
    }

    public void checkAdjacentTiles(Pair pair) {
//        System.out.println( "pair = " + pair );
        int sum = 0;
        int x = pair.getX();
        int y = pair.getY();
        sum += checkTile( x - 2, y );
        sum += checkTile( x + 2, y );
        sum += checkTile( x + 1, y + 1 );
        sum += checkTile( x + 1, y - 1 );
        sum += checkTile( x - 1, y + 1 );
        sum += checkTile( x - 1, y - 1 );

        //Any black tile with zero or more than 2 black tiles immediately adjacent to it is flipped to white.
        Hex hex = new Hex( "" );
        if ( tiles.get( pair ).isBlack() ) {
            if ( sum == 1 || sum == 2 ) {
                hex.flipColor();
            }
        }
        else {
            if ( sum == 2 ) {
                hex.flipColor();
            }
        }
        temp.put( pair, hex );
    }

    private int checkTile(int x, int y) {
        Hex hex = tiles.get( new Pair( x, y ) );
        if ( hex == null ) {
            return 0;
        }
        return hex.isBlack() ? 1 : 0;
    }

    private void initEmptyTiles() {
        for (int i = -SIZE; i < SIZE; i++) {
            for (int j = -SIZE; j < SIZE; j++) {
                var pair = new Pair( i, j );
                tiles.put( pair, new Hex( pair ) );
            }
        }
    }

    private void setUpTile(String s) {
        Hex hex = new Hex( s );
        tiles.get( hex.getPair() ).flipColor();
    }

    @NotNull
    private List<String> getCollect(List<String> lines) {
        return lines.stream()
                .map( s -> s.replace( "se", "b" )
                        .replace( "ne", "h" )
                        .replace( "sw", "d" )
                        .replace( "nw", "k" )
                        .replace( "nw", "k" ) )
                .collect( Collectors.toList() );
    }
}
