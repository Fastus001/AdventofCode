package com.karczmarzyk.advent2020.day24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainPartOne {
    public static final Pattern SPLIT = Pattern.compile( "" );
    private static Map<Pair,Hex> list = new HashMap<>();

    public static void main(String[] args) throws IOException {
        var lines = Files.readAllLines( Path.of( "src/main/resources/2020/day24/input.txt" ) );
        var collect = lines.stream()
                .map( s -> s.replace( "se", "b" )
                        .replace( "ne", "h" )
                .replace( "sw", "d" )
                .replace( "nw", "k" )
                .replace( "nw", "k" ))
                .collect( Collectors.toList() );

        for (String s : collect) {
            Hex hex = new Hex( s );
            if(list.get( hex.getPair() )==null){
                list.put( hex.getPair(),hex );
            }else{
                list.get( hex.getPair() ).flipColor();
            }
        }
        var count = list.values().stream()
                .filter( Hex::isBlack )
                .count();

        System.out.println( "count = " + count );

    }
}
