package com.karczmarzyk.advent2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task5 {
    public static final Pattern VOWELS = Pattern.compile("[aeiou]");
    public static final Pattern DLETTERS = Pattern.compile("(.)\\1");
    public static final Pattern NOT_ALLOWED = Pattern.compile("ab|cd|pq|xy");

    public ArrayList<String> lista = new ArrayList<>();

    public void readInput()
    {
        try (var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/task5input.txt")))
        {
            while (in.hasNext())
            {
                String line = in.next();
                lista.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isVowelsPresent(String s)
    {
        int counter = 0;
        Matcher matcher = VOWELS.matcher(s);
        while(matcher.find())
        {
            counter++;
        }
        if(counter>=3)
            return true;
        else
            return false;
    }

    public boolean isContainPairOfLetters(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            String test = s.substring(i,i+2);
            if((s.length()-(i+2))==1)
                break;
            String rest = s.substring(i+2,s.length());
            if(rest.contains(test))
                return true;
        }
        return false;
    }

    public boolean isRepeatWithOnlyOneLetter(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i,i+1);
            if(i+2<s.length())
            {
                String x = s.substring(i+2,i+3);
                if(c.equals(x))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Task5 task = new Task5();
        task.readInput();
        Predicate<String> predicate2 = DLETTERS.asPredicate();
        var predicate3 = NOT_ALLOWED.asPredicate().negate();
        /*pierwsza cz?? zadania
        List<String> collect = task.lista.stream()
                .filter(predicate2)
                .filter(predicate3)
                .filter(task::isVowelsPresent)
                .collect(Collectors.toList());
        */
        List<String> onlyWithDoubleOccurences = task.lista.stream()
                .filter(task::isContainPairOfLetters)
                .filter(task::isRepeatWithOnlyOneLetter)
                .collect(Collectors.toList());

        System.out.println("collect = " + onlyWithDoubleOccurences.size());

    }
}
