package com.karczmarzyk.advent2015.Day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class AuntSue {

    public static boolean isChildrenOtherThanThree(String pattern)
    {
        String pat = "children";
        String fullPat = "children: 3";
        if(pattern.contains(pat))
        {
            return pattern.contains(fullPat);
        }
        return true;
    }

    public static boolean isCatsOtherThanSeven(String pattern)
    {
        String pat = "cats";
        String fullPat = "cats: 7";
        if(pattern.contains(pat))
        {
            return pattern.contains(fullPat);
        }
        return true;
    }
    public static boolean isSanoyedsOtherThanTwo(String pattern)
    {
        String pat = "samoyeds";
        String fullPat = "samoyeds: 2";
        if(pattern.contains(pat))
        {
            return pattern.contains(fullPat);
        }
        return true;
    }
    public static boolean isPomeraniansOtherThanThree(String pattern)
    {
        String pat = "pomeranians";
        String fullPat = "pomeranians: 3";
        if(pattern.contains(pat))
        {
            return pattern.contains(fullPat);
        }
        return true;
    }

    public static boolean isAkitasOtherThanThree(String pattern)
    {
        String pat = "akitas";
        String fullPat = "akitas: 0";
        if(pattern.contains(pat))
        {
            return pattern.contains(fullPat);
        }
        return true;
    }
    public static boolean isVizslasOtherThanZero(String pattern)
    {
        String pat = "vizslas";
        String fullPat = "vizslas: 0";
        if(pattern.contains(pat))
        {
            return pattern.contains(fullPat);
        }
        return true;
    }
    public static boolean isGoldfishOtherThanFive(String pattern)
    {
        String pat = "goldfish";
        String fullPat = "goldfish: 5";
        if(pattern.contains(pat))
            return pattern.contains(fullPat);
        return true;
    }
    public static boolean isTreesOtherThanThree(String pattern)
    {
        String pat = "trees";
        String fullPat = "trees: 3";
        if(pattern.contains(pat))
            return pattern.contains(fullPat);
        return true;
    }
    public static boolean isCarsOtherThanTwo(String pattern)
    {
        String pat = "cars";
        String fullPat = "cars: 2";
        if(pattern.contains(pat))
            return pattern.contains(fullPat);
        return true;
    }

    public static boolean isPerfumesOtherThanOne(String pattern)
    {
        String pat = "perfumes";
        String fullPat = "perfumes: 1";
        if(pattern.contains(pat))
            return pattern.contains(fullPat);
        return true;
    }


    public static void main(String[] args) throws IOException {
        final List<String> inList = Files.readAllLines(Path.of("src/com/karczmarzyk/advent2015/resources/day16.txt"));
        List<String> result = inList.stream()
                .filter(s -> s.contains("children: 3") || s.contains("cats: 7") || s.contains("samoyeds: 2")
                || s.contains("pomeranians: 3") || s.contains("akitas: 0") || s.contains("vizslas: 0")
                || s.contains("goldfish: 5") || s.contains("trees: 3") || s.contains("cars: 2") || s.contains("perfumes: 1"))
                .collect(Collectors.toList());

        System.out.println("result = " + result);
        System.out.println("result.size() = " + result.size());

        List<String> result2 = result.stream()
                .filter(AuntSue::isChildrenOtherThanThree)
                .filter(AuntSue::isCatsOtherThanSeven)
                .filter(AuntSue::isSanoyedsOtherThanTwo)
                .filter(AuntSue::isPomeraniansOtherThanThree)
                .filter(AuntSue::isAkitasOtherThanThree)
                .filter(AuntSue::isVizslasOtherThanZero)
                .filter(AuntSue::isGoldfishOtherThanFive)
                .filter(AuntSue::isTreesOtherThanThree)
                .filter(AuntSue::isCarsOtherThanTwo)
                .filter(AuntSue::isPerfumesOtherThanOne)
                .collect(Collectors.toList());

        System.out.println("result2 = " + result2);
        System.out.println("result2.size() = " + result2.size());
    }
}
