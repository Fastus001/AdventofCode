package com.karczmarzyk.advent2017.day16;

import lombok.Data;

@Data
public class Move {
    private String name;
    private char programA;
    private char programB;
    private int valueA;
    private int valueB;

    public Move(String input) {
        name = input.substring(0,1);
        String[] split = input.substring(1).split("/");
        if(name.equals("s")){
            valueA = Integer.parseInt(split[0].trim());
        }else if(name.equals("x")) {
            valueA = Integer.parseInt(split[0].trim());
            valueB = Integer.parseInt(split[1].trim());
        }else {
            programA = split[0].charAt(0);
            programB = split[1].charAt(0);
        }
    }
}
