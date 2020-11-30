package com.karczmarzyk.advent2015.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DinnerTable {
    public static final String [] GUESTS_NAMES = {"Alice","Bob","Carol","David","Eric","Frank","George","Mallory","Tomek"};
    public static ArrayList<List<String>> PERMUTATIONS = new ArrayList<>();
    public static ArrayList<Guest> GUESTS = new ArrayList<>();


    public static void main(String[] args) {
        generatePermutation(GUESTS_NAMES.length, GUESTS_NAMES);
        getDataInput();
        int result = PERMUTATIONS.stream()
                .mapToInt(DinnerTable::getHappinessNumber)
                .max()
                .orElse(-1);

        System.out.println("wynik = " + result);
    }

    private static int getHappinessNumber(List<String> list)
    {
        int sum = 0;
        String name;
        String friend;
        for (int i = 0; i < list.size(); i++) {
            name = list.get(i);
            if(i == 0)
            {
                friend = list.get(list.size()-1);
                sum = getSum(sum, name, friend);
                friend = list.get(i+1);
                sum = getSum(sum, name, friend);
            }else if(i == list.size()-1)
            {
                friend = list.get(i-1);
                sum = getSum(sum, name, friend);
                friend = list.get(0);
                sum = getSum(sum, name, friend);
            }else{
                friend = list.get(i-1);
                sum = getSum(sum, name, friend);
                friend = list.get(i+1);
                sum = getSum(sum, name, friend);
            }
        }
        return sum;
    }

    private static int getSum(int sum, String name, String friend) {
        for (Guest g : GUESTS) {
            if (g.getName().equals(name) && g.getFriend().equals(friend))
                sum += g.getHappiness();
        }
        return sum;
    }

    private static void getDataInput() {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/day13.txt")))
        {
            while(in.hasNext())
            {
                String[] tab = in.nextLine().split("\\s");
                int number;
                if(tab[2].equals("lose"))
                    number = Integer.parseInt("-"+tab[3]);
                else
                    number = Integer.parseInt(tab[3]);
                Guest guest = new Guest(tab[0],tab[tab.length-1], number);
                GUESTS.add(guest);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void generatePermutation(int k, String[] array)
    {
        if(k==1) {
            List<String> collect =
                    Stream.of(array)
                            .collect(Collectors.toList());
            PERMUTATIONS.add(collect);
        } else
        {
            generatePermutation(k-1,array);
            for (int i = 0; i < k-1; i++) {
                if(k % 2 ==0)
                    swap(array,i,k-1);
                else
                    swap(array,0,k-1);
                generatePermutation(k-1,array);
            }
        }
    }

}
