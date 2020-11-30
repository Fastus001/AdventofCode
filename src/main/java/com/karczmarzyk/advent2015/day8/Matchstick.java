package com.karczmarzyk.advent2015.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Matchstick {
    public static final Pattern HEX = Pattern.compile("(\\\\x[0-9a-f]{2})");
    public static final Pattern DBLBACKSL = Pattern.compile("\\\\\\\\");
    public static final Pattern APOST = Pattern.compile("\\\\\\\"");
    public static final Pattern SIN_APOST = Pattern.compile("\\\"");

    public static ArrayList<String> IN_LIST = new ArrayList<>();

    public static  void getInput()
    {
         try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/matchstick.txt")))
        {
            while(in.hasNext())
            {
                String line = in.nextLine();
                IN_LIST.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getInput();
        System.out.println("IN_LIST = " + IN_LIST);
        long count = IN_LIST.stream().map(String::length).reduce(Integer::sum).orElse(0);
        /*
        DAY 8 - PART 1
         */
//        IN_LIST.replaceAll(s -> DBLBACKSL.matcher(s).replaceAll("a"));
//        IN_LIST.replaceAll(s -> APOST.matcher(s).replaceAll("a"));
//        IN_LIST.replaceAll(s -> HEX.matcher(s).replaceAll("a"));
//        IN_LIST.replaceAll(s -> SIN_APOST.matcher(s).replaceAll(""));

        /*
        DAY 8 - PART 2
         */
        IN_LIST.replaceAll(s -> DBLBACKSL.matcher(s).replaceAll("XXXX"));
        IN_LIST.replaceAll(s -> APOST.matcher(s).replaceAll("ssss"));
        IN_LIST.replaceAll(s -> SIN_APOST.matcher(s).replaceAll("bbb"));
        IN_LIST.replaceAll(s -> HEX.matcher(s).replaceAll("HHHHH"));
        long count2 = IN_LIST.stream().map(String::length).reduce(Integer::sum).orElse(0);

        System.out.println("count = " + count);
        System.out.println("count2 = " + count2);

        System.out.println("sum = " + (count-count2));

    }

}
