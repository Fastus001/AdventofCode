package com.karczmarzyk.advent2015.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class JSAbacusFramework {
    public static final Pattern NUMS = Pattern.compile("(-?\\d+)");

    public static void main(String[] args) throws IOException {
        String tekst = new String(Files.readAllBytes(Path.of("src/com/karczmarzyk/advent2015/resources/day12.txt")));

        String result = isRedInSubstring(tekst);
        while(result.contains("{"))
        {
            result = isRedInSubstring(result);
        }
        System.out.println("result = " + result);

        int sumPart2 = NUMS.matcher(result).results()
                .map(MatchResult::group)
                .mapToInt(s -> Integer.parseInt(s))
                .sum();
        System.out.println("sum = " + sumPart2);

//        //PART 1
//        int sum = NUMS.matcher(tekst).results()
//                .map(MatchResult::group)
//                .mapToInt(s -> Integer.parseInt(s))
//                .sum();
//        System.out.println("sum = " + sum);

    }


    private static String isRedInSubstring(String input) {
        boolean toCancel = false;
        int start = 0;
        int end = 0;
        int counter = 0;
        StringBuilder tempSb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'r' && counter==1)
            {
                toCancel = true;
            }
            if(input.charAt(i) == '{' && counter==0)
            {
                start = i;
                counter++;
            }else if((input.charAt(i) == '{' || input.charAt(i)=='[') && counter !=0)
                counter++;
            if((input.charAt(i) == '}' || input.charAt(i) == ']') && counter !=0)
                counter--;
            if(input.charAt(i) == '}' && counter==0){
                end = i+1;
                tempSb.append(input.substring(start,end));
                input = input.replace(tempSb,"");
                tempSb.replace(0,0+1,"[");
                tempSb.replace(tempSb.length()-1,tempSb.length(),"]");
                if(toCancel)
                    return input;
                else
                    return tempSb.append(input).toString();
            }
        }
        return input+"bbbbb";
    }
}
