package com.karczmarzyk.advent2020.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JigSaw {
    private List<Tile> tiles = new ArrayList<>();
    private List<String> test = new ArrayList<>();

    public JigSaw(String path) throws IOException {
        List<String> strings = Files.readAllLines( Path.of( path ) );
        List<String> temp = new ArrayList<>();
        for(String s:strings){
            if(s.length()!=0){
                temp.add( s );
                if(temp.size()==11){
                    tiles.add(  new Tile( temp ));
                    addStringsToTestList( temp );
                }
            }else{
                temp.clear();
            }
        }
    }


    private void addStringsToTestList(List<String> temp) {
        String x = temp.get( 1 );
        test.add( x );
        test.add( new StringBuilder(x).reverse().toString());
        x = temp.get( 10 );
        test.add( x );
        test.add( new StringBuilder(x).reverse().toString());
        x = getColumn( temp, 0);
        test.add( x );
        test.add( new StringBuilder(x).reverse().toString());
        x = getColumn( temp, 9);
        test.add(x );
        test.add( new StringBuilder(x).reverse().toString());
    }

    private String getColumn(List<String> temp, int i) {
        String substring = temp.stream()
                .map( s -> s.substring( i, i + 1 ) )
                .collect( Collectors.joining() )
                .substring( 1 );
        return substring;
    }

    public Tile getTiles(int index) {
        return tiles.get( index );
    }

    public int getTileSize(){
        return tiles.size();
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
