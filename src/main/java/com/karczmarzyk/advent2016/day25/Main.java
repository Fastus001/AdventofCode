package com.karczmarzyk.advent2016.day25;

import com.karczmarzyk.advent2016.day12.Monorail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Monorail partOne = new Monorail();
        partOne.setInstructions(
                Files.readAllLines( Path.of( "src/main/resources/2016/day25/input.txt" ) ));
        boolean check = false;
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            if(check){
                break;
            }
            partOne.setAndReset( i );
            while (true){
                partOne.start();
                if(partOne.getSizeOfResult()==20){
                    if(partOne.isResultsOk()){
                        System.out.println( "partOne = " + partOne.getResults() );
                        System.out.println("koniec" +i);
                        check = true;
                    }
                    break;
                }
            }
        }
     }
}
