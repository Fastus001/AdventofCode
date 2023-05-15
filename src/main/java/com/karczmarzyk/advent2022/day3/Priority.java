package com.karczmarzyk.advent2022.day3;

public class Priority {

    public static int getPriority(String s){
        final int codePoint = s.codePointAt(0);
        return codePoint > 96 ?
                codePoint - 96 : codePoint - 38;
    }
}
