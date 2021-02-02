package com.karczmarzyk.advent2016.day18;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> resultRows = new ArrayList<>();
        Traps traps = new Traps();
        String start = "^.^^^.^..^....^^....^^^^.^^.^...^^.^.^^.^^.^^..^.^...^.^..^.^^.^..^.....^^^.^.^^^..^^...^^^...^...^.";
        resultRows.add( start );
        for (int i = 1; i < 400000; i++) {
            start =  traps.getNewRow(start);
            resultRows.add( start );
        }

        long count = resultRows.stream()
                .flatMapToInt( String::chars )
                .filter( i -> i == 46 )
                .count();

        System.out.println( "count = " + count );


    }
}
