package com.karczmarzyk.advent2015.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AllinaSingleNight {
    public static final String [] tab = {"Tristram","AlphaCentauri","Snowdin","Tambi","Faerun","Norrath","Straylight","Arbre"};
    public static ArrayList<String> permutations = new ArrayList<>();
    public static HashMap<String, Integer> routes = new HashMap<>();

    public static void populateRoutesMap()
    {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/day9.txt")))
        {
            while (in.hasNext())
            {
                String[] temp = in.nextLine().split("\\s+");
                routes.put(temp[0]+temp[2],Integer.parseInt(temp[4]));
                routes.put(temp[2]+temp[0],Integer.parseInt(temp[4]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int sumRouteDistance(String route)
    {
        Integer distance = 0;
        String[] towns = route.split(",");
        for (int i = 0; i < towns.length; i++) {
            if(i == towns.length-1)
                break;
            distance+= routes.get(towns[i]+towns[i+1]);
        }
        return distance;
    }

    public static void generateArrayPermutation(int k, String[] array)
    {
        if(k==1)
            permutations.add(String.join(",", array));
        else
        {
            generateArrayPermutation(k-1,array);
            for (int i = 0; i < k-1; i++) {
                if(k % 2 ==0)
                    swap(array,i,k-1);
                else
                    swap(array,0,k-1);
                generateArrayPermutation(k-1,array);
            }
        }
    }

    private static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {
        generateArrayPermutation(tab.length, tab);
        System.out.println("permutations = " + permutations.size());
        populateRoutesMap();

        /*
        PART 1
         */
        int min = permutations.stream()
                .mapToInt(AllinaSingleNight::sumRouteDistance)
                .min()
                .orElse(0);
        System.out.println("Droga najkrtsza MAX= " + min);

        /*
        PART 2
         */
        int max = permutations.stream()
                .mapToInt(AllinaSingleNight::sumRouteDistance)
                .max()
                .orElse(0);
        System.out.println("Droga nadusza MAX= " + max);

    }
}
