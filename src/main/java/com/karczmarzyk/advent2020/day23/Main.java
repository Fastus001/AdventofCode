package com.karczmarzyk.advent2020.day23;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int SIZE = 1_000_000;
    List<Integer> caps = new LinkedList<>();
    public Main(String in) {
        for (int i = 0; i < SIZE; i++) {
            if(i<in.length()){
                caps.add( Integer.parseInt( in.substring( i, i + 1 ) ) );
            }else{
                caps.add( i+1 );
            }
        }
    }
}
