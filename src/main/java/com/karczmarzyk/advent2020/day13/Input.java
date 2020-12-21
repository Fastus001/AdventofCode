package com.karczmarzyk.advent2020.day13;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<Bus> getListOfBuses(String input){
        String[] split = input.split(",");
        List<Bus> buses = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(!split[i].equals("x")){
                buses.add(new Bus(Integer.parseInt(split[i]),i));
            }
        }
        return buses;
    }
}
