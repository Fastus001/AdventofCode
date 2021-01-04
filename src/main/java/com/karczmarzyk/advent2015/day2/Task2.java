package com.karczmarzyk.advent2015.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2 {
    public ArrayList<ArrayList<Integer>> inputList = new ArrayList<>();
    public static final Pattern PATTERN = Pattern.compile("x");

    public void getInput()
    {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/input.txt")))
        {
            while(in.hasNext())
            {
                String [] tab = in.nextLine().split("x");
                ArrayList<Integer> list = new ArrayList<>();
                for(String s:tab)
                    list.add(Integer.parseInt(s));
                list.sort(Comparator.naturalOrder());
                inputList.add(list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Task2 task = new Task2();
        task.getInput();
        Integer reduce = task.inputList.stream()
                .map(i -> i.get(0) * i.get(1) * i.get(2)+(2*i.get(0)+2*i.get(1)))
                .reduce(Integer::sum).orElse(0);

        System.out.println("reduce = " + reduce);


        System.out.println("task.inputList = " + task.inputList);
    }
}
