package com.karczmarzyk.advent2017.day14;

import com.karczmarzyk.advent2017.day10.KnotHash;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Defrag {
    private int regions = 0;
    private final Map<Character, String> bitMap = new HashMap<>();
    private final char [][] tab= new char[128][];

    public Defrag() {
        bitMap.put('0', "0000");
        bitMap.put('1', "000X");
        bitMap.put('2', "00X0");
        bitMap.put('3', "00XX");
        bitMap.put('4', "0X00");
        bitMap.put('5', "0X0X");
        bitMap.put('6', "0XX0");
        bitMap.put('7', "0XXX");
        bitMap.put('8', "X000");
        bitMap.put('9', "X00X");
        bitMap.put('a', "X0X0");
        bitMap.put('b', "X0XX");
        bitMap.put('c', "XX00");
        bitMap.put('d', "XX0X");
        bitMap.put('e', "XXX0");
        bitMap.put('f', "XXXX");
    }

    public int getSquares(String puzzleInput) {
        int sum = 0;
        for (int i = 0; i < 128; i++) {
            KnotHash knotHash = new KnotHash(256);
            String generatedHash = knotHash.generate(puzzleInput + "-" + i);
            String bitString = hexToBitConverter(generatedHash);
            sum += bitCounter(bitString);
            tab[i] =  bitString.toCharArray();
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
            if(c == 'X') {
                sum++;
            }
        }
        return sum;
    }

    public int scanForRegions() {
        for (int row = 0; row < 128; row++) {
            for (int col = 0; col < 128; col++) {
             if (isValue(row, col)) {
                 regions++;
                 checkRegion(row, col);
             }
            }
        }
        return regions;
    }

    private void checkRegion(int row, int col) {
        if (isValue(row, col)){
            tab[row][col] = '0';
        }
        if(isValue(row, col+1)) {
            checkRegion(row, col+1);
        }
        if(isValue(row, col-1)) {
            checkRegion(row, col-1);
        }
        if(isValue(row+1, col)) {
            checkRegion(row+1, col);
        }
        if(isValue(row-1, col)) {
            checkRegion(row-1, col);
        }
    }

    private boolean isValue(int x, int y) {
        if(x < 0 || x > 127 || y < 0 || y > 127) {
            return false;
        }
        return tab[x][y] == 'X';
    }
}
