package com.karczmarzyk.advent2017.day9;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public static List<String> garbage = new ArrayList<>();

    public static String cleanCanceled(String input) {
        if(input.contains("!")){
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '!') {
                    input = input.substring(0, i) + input.substring(i+2);
                    return JsonParser.cleanCanceled(input);
                }
            }
        }
        return input;
    }

    public static String removeGarbage(String input) {
        if(input.contains("<")){
            int start = input.indexOf("<");
            int end = input.indexOf(">");
            garbage.add(input.substring(start+1, end));
            return JsonParser.removeGarbage(input.substring(0,start) + input.substring(end+1));
        }
        return input;
    }

    public static int count(String input) {
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '{'){
                counter++;
            }
            if(input.charAt(i) == '}'){
                sum += counter;
                counter--;
            }
        }
        return sum;
    }

    public static int countGarbage(){
        return garbage.stream()
                .mapToInt(String::length)
                .sum();
    }

}
