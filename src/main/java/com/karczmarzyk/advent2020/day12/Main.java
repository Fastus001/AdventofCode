package com.karczmarzyk.advent2020.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //part1
//        Ship ship = new Ship();
        ShipAdv ship = new ShipAdv();
        List<String> strings = new ArrayList<>();
        try {
           strings = Files.readAllLines(Path.of("src/main/resources/2020/day12/day12.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String s:strings){
            String d = s.substring(0,1);
            int value = Integer.parseInt(s.substring(1));
            ship.move(d,value);
        }
        System.out.println("ship = " + ship.getShipLocation());
    }
}
