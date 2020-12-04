package com.karczmarzyk.advent2015.day14;

import com.karczmarzyk.advent2015.day14.ReindeerVer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReindeerPart2 {
    public static final Pattern REIND = Pattern.compile("^(\\w+).+?(\\d+).+?(\\d+).+?(\\d+)");
    public static ArrayList<ReindeerVer2> reindeers = new ArrayList<>();

    public static void getInput()
    {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/day14.txt")))
        {
            while (in.hasNext())
            {
                ReindeerVer2 reindeer = REIND.matcher(in.nextLine()).results()
                        .map(mr -> new ReindeerVer2(mr.group(1), Integer.parseInt(mr.group(2)),
                                Integer.parseInt(mr.group(3)), Integer.parseInt(mr.group(4))))
                        .findFirst()
                        .orElseThrow();
                reindeers.add(reindeer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getLongestDistanceReindeer(ArrayList<ReindeerVer2> reindeers, int number)
    {
        int max = 0;
        for (ReindeerVer2 r: reindeers) {
            if(r.distanceEachSecond.get(number)>max)
            {
                max = r.distanceEachSecond.get(number);
            }
        }
        for (ReindeerVer2 r: reindeers) {
            if(r.distanceEachSecond.get(number) == max)
                r.addOneScore();
        }
    }

    public static void main(String[] args) {
        int seconds = 2503;
        getInput();
        System.out.println("reindeers = " + reindeers);
        reindeers.forEach(reindeer -> reindeer.addDistance(seconds));
        for(int i = 0; i < seconds; i++) {
            getLongestDistanceReindeer(reindeers, i);
        }
        Integer maxScore = reindeers.stream()
                .map( ReindeerVer2::getScore )
                .max(Integer::compareTo)
                .orElse(-1);
        System.out.println("maxScore = " + maxScore);
    }
}
