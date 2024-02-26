package com.karczmarzyk.advent2023.day1;

import java.util.List;

public class Trebuchet {
    static String getNumber(String line) {
        char[] charArray = line.toCharArray();
        char first = 0;
        for (char c : charArray) {
            if (c > 47 && c < 58) {
                first = c;
                break;
            }
        }
        char last = 0;
        for (int i = charArray.length-1; i >= 0; i--) {
            if (charArray[i] > 47 && charArray[i] < 58 ) {
                last = charArray[i];
                break;
            }
        }
        return ""+ first + last;
    }

    static int getSum(List<String> strings) {
        return strings.stream()
                .map(Trebuchet::getNumber)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
