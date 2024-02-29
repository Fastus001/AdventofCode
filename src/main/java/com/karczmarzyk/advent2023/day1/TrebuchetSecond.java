package com.karczmarzyk.advent2023.day1;

import java.util.Map;
import java.util.function.Function;

public class TrebuchetSecond {

    private static final Map<Integer, Function<String, String>> NUMBERS =
            Map.of(
                        0, replace("oneight", "18"),
                    1, replace("one", "1"),
                    2, replace("two", "2"),
                    3, replace("three", "3"),
                    4, replace("four", "4"),
                    5, replace("five", "5"),
                    6, replace("six", "6"),
                    7, replace("seven", "7"),
                    8, replace("eight", "8"),
                    9, replace("nine", "9")
            );


    public String convert(String s) {
        s = replace("eightwo", "82").apply(s);
        s = replace("twone", "21").apply(s);
        for (int i = 0; i < NUMBERS.size(); i++) {
            s = NUMBERS.get(i).apply(s);
        }
        return s;
    }

    private static Function<String, String> replace(String word, String number) {
        return s -> {
            if (s.contains(word)) {
                s = s.replace(word, number);
            }
            return s;
        };
    }
}
