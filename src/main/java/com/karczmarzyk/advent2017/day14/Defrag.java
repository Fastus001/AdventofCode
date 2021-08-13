package com.karczmarzyk.advent2017.day14;

import com.karczmarzyk.advent2017.day10.KnotHash;

import java.util.HashMap;
import java.util.Map;

public class Defrag {
    private final Map<Character, String> bitMap = new HashMap<>();

    public Defrag() {
        bitMap.put('0', "0000");
        bitMap.put('1', "0001");
        bitMap.put('2', "0010");
        bitMap.put('3', "0011");
        bitMap.put('4', "0100");
        bitMap.put('5', "0101");
        bitMap.put('6', "0110");
        bitMap.put('7', "0111");
        bitMap.put('8', "1000");
        bitMap.put('9', "1001");
        bitMap.put('a', "1010");
        bitMap.put('b', "1011");
        bitMap.put('c', "1100");
        bitMap.put('d', "1101");
        bitMap.put('e', "1110");
        bitMap.put('f', "1111");
    }

    public int getSquares(String puzzleInput) {
        int sum = 0;
        for (int i = 0; i < 128; i++) {
            KnotHash knotHash = new KnotHash(256);
            String generatedHash = knotHash.generate(puzzleInput + "-" + i);
            String bitString = hexToBitConverter(generatedHash);
            sum += bitCounter(bitString);
        }
        return sum;
    }

    private String hexToBitConverter(String hexString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hexString.length(); i++) {
            char charAt = hexString.charAt(i);
            sb.append(bitMap.get(charAt));
        }
        return sb.toString();
    }

    private int bitCounter(String hash) {
        int sum = 0;
        for (char c : hash.toCharArray()) {
            if(c == '1') {
                sum++;
            }
        }
        return sum;
    }
}
