package com.karczmarzyk.advent2015.Day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReindeerOlympics {
    public static final Pattern REIND = Pattern.compile("^(\\w+).+?(\\d+).+?(\\d+).+?(\\d+)");
    public static ArrayList<Reindeer> reindeers = new ArrayList<>();

    public static void getInput()
    {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/day14.txt")))
        {
            while (in.hasNext())
            {
                Reindeer reindeer = REIND.matcher(in.nextLine()).results()
                        .map(mr -> new Reindeer(mr.group(1), Integer.parseInt(mr.group(2)),
                                Integer.parseInt(mr.group(3)), Integer.parseInt(mr.group(4))))
                        .findFirst()
                        .orElseThrow();
                reindeers.add(reindeer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getInput();
        System.out.println("reindeers = " + reindeers);
        Integer maxDistance = reindeers.stream()
                .map(reindeer -> reindeer.getDistance(2503))
                .max(Integer::compareTo)
                .orElseThrow();
        System.out.println("integer max = " + maxDistance);

    }
}
