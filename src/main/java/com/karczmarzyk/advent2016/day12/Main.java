package com.karczmarzyk.advent2016.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Monorail partOne = new Monorail();
        partOne.setInstructions(
                Files.readAllLines( Path.of( "src/main/resources/2016/day12/input.txt" ) ));
        int size = partOne.getInstructions().size();
        int partOneResult = 0;

        while (partOne.getCurrentIndex()<size){
            partOneResult = partOne.start();
        }

        System.out.println(partOneResult);

    }
}
