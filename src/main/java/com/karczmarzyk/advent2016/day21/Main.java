package com.karczmarzyk.advent2016.day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines( Path.of( "src/main/resources/2016/day21/input.txt" ) );

        Parser parser = new Parser( new Scrambler( "abcdefgh" ) );

        inputLines.forEach( parser::scramblerFunctions );

        String result = parser.getScrambler().toString();

        System.out.println( "result = " + result );
    }
}
