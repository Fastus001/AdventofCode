package com.karczmarzyk.advent2016.day21;

import com.karczmarzyk.utils.Generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final String [] LETTERS = {"a","b","c","d","e","f","g","h"};

    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines( Path.of( "src/main/resources/2016/day21/input.txt" ) );

        Parser parser = new Parser( new Scrambler( "abcdefgh" ) );
        inputLines.forEach( parser::scramblerFunctions );
        System.out.println( "result = " + parser.getScrambler().toString() );
        //part one!

        //part two!
        Generator.generatePermutation( LETTERS.length,LETTERS );
        List<String> strings1 = Generator.PERMUTATIONS.stream()
                .map( strings -> String.join( "", strings ) )
                .collect( Collectors.toList() );


        for (String s : strings1) {
            Parser temp = new Parser( new Scrambler( s ) );
            inputLines.forEach( temp::scramblerFunctions );
            if(temp.getScrambler().toString().equals( "fbgdceah" )){
                System.out.println( "s = " + s );
                break;
            }
        }

    }
}
