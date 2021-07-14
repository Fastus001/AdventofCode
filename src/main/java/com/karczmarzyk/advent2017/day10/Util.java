package com.karczmarzyk.advent2017.day10;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static int [] parseInput(String input){
        int [] endSequence = new int[]{17,31,73,47,23};

        int [] temp = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            temp[i]= input.charAt(i);
        }
        int [] returnArray = new int[temp.length+endSequence.length];
        System.arraycopy(temp,0, returnArray,0, temp.length);
        System.arraycopy(endSequence,0, returnArray,temp.length, endSequence.length);

        return returnArray;
    }

    public static Integer getXOR(List<Integer> sublist) {
        return sublist.stream()
                .reduce((integer, integer2) -> integer^integer2)
                .orElseThrow();
    }

    public static String toHex(int number){
        String hexString = Integer.toHexString(number);
        return hexString.length()==1 ? "0"+hexString : hexString;
    }

    public static String densHash(List<Integer> integers){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int index = i * 16;
            Integer xorNumber = Util.getXOR(integers.subList(index, index + 16));
            temp.append(Util.toHex(xorNumber));
        }
        return temp.toString();
    }
}
