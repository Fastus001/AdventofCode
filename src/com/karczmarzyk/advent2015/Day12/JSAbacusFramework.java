package com.karczmarzyk.advent2015.Day12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class JSAbacusFramework {
    public static final Pattern NUMS = Pattern.compile("(-?\\d+)");
    public static List<String> tablice = new ArrayList<String>();
    public static List<String> obiekty = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
//        String tekst = new String(Files.readAllBytes(Path.of("src/com/karczmarzyk/advent2015/resources/day12.txt")));

        //TODO - zaczytywaæ nawiasy klamrowe od "nasjstarszgo'!!!
        String tekst = "{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}";
        String nowy = "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < tekst.length(); i++) {
            if(tekst.charAt(i) == '[')
                start = i;
            if(tekst.charAt(i) == ']'){
                end = i+1;
                nowy = tekst.substring(start,end);
                tekst = tekst.replace(nowy,"");
            }
        }
        System.out.println("nowy = " + nowy);
        System.out.println("tekst = " + tekst);


        //PART 1
//        int sum = NUMS.matcher(tekst).results()
//                .map(MatchResult::group)
//                .mapToInt(s -> Integer.parseInt(s))
//                .sum();
//        System.out.println("sum = " + sum);

    }
}
