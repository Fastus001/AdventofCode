package com.karczmarzyk.advent2016.day23;

import com.karczmarzyk.advent2016.day12.Monorail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Monorail partOne = new Monorail();
        partOne.setInstructions(
                Files.readAllLines( Path.of( "src/main/resources/2016/day23/input.txt" ) ));
        int size = partOne.getInstructions().size();
        int partOneResult = 0;
        int counter = 0;
        while (partOne.getCurrentIndex()<size){
                partOneResult = partOne.start();
                if(counter%10000000==0){
                    System.out.println(partOne.getRegisters() + " " + partOne.getCurrentIndex());
                }
            counter++;
        }

        System.out.println(partOneResult);

    }
}
