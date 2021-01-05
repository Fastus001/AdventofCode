package com.karczmarzyk.advent2020.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JigSaw {
    private List<Tile> tiles = new ArrayList<>();

    public JigSaw(String path) throws IOException {
        List<String> strings = Files.readAllLines( Path.of( path ) );
        List<String> temp = new ArrayList<>();
        for(String s:strings){
            if(s.length()!=0){
                temp.add( s );
                if(temp.size()==11){
                    tiles.add(  new Tile( temp ));
                }
            }else{
                temp.clear();
            }
        }
    }

    public Tile getTiles(int index) {
        return tiles.get( index );
    }

    public int getTileSize(){
        return tiles.size();
    }
}
