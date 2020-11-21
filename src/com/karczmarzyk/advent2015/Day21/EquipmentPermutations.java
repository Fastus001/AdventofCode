package com.karczmarzyk.advent2015.Day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EquipmentPermutations {
    public static int [] NUMBERS = {10,11,12,13,14,15};
    private final ArrayList<List<Item>> allPermutations = new ArrayList<>();
    private final List<Item> listOfItems = new ArrayList<>();
    private final ArrayList<List<Item>> permutationsWeaponAndArmour = new ArrayList<>();
    private final ArrayList<List<Item>> permutationsOfRings = new ArrayList<>();

    public void getItemsData() {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/day21.txt")))
        {
            while (in.hasNext())
            {
                String [] tab = in.nextLine().split(",");
                listOfItems.add(new Item(tab[0],Integer.parseInt(tab[1]),
                        Integer.parseInt(tab[2]),Integer.parseInt(tab[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        generateWeaponAndArmour();
        generateRings();
        getAllPermutations();
    }

    public int getSizeOfItems() {
        return listOfItems.size();
    }

    private void generateWeaponAndArmour() {
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j < 10; j++) {
                List<Item> t = new ArrayList<>();
                t.add(listOfItems.get(i));
                if(j>4)
                    t.add(listOfItems.get(j));
                permutationsWeaponAndArmour.add(t);
            }
        }
    }

    private void generateRings() {
        for (int i = 10; i < listOfItems.size(); i++) {
            permutationsOfRings.add(List.of(listOfItems.get(i)));
        }
        List<int[]> combinations = this.generate(6);
        for(int[] t:combinations)
        {
            List<Item> list = new ArrayList<>();
            for (int j : t) {
                list.add(listOfItems.get(j));
            }
            permutationsOfRings.add(list);
        }
    }


    private void helper(List<int[]> combinations, int[] data, int start, int end, int index)
    {
        if(index== data.length)
        {
            int[] combination = data.clone();
            combinations.add(combination);
        }else if(start <= end){
            data[index] = NUMBERS[start];
            helper(combinations, data, start+1, end, index+1);
            helper(combinations, data, start+1, end, index);
        }
    }

    private List<int[]> generate(int n)
    {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[2], 0, n-1,0);
        return combinations;
    }

    private void getAllPermutations() {

        allPermutations.addAll(permutationsWeaponAndArmour);
        for(List<Item> weap:permutationsWeaponAndArmour)
        {
            for (List<Item> rings: permutationsOfRings)
            {
                List<Item> nowy = new ArrayList<>();
                nowy.addAll(weap);
                nowy.addAll(rings);
                allPermutations.add(nowy);
            }
        }
    }

    public int getPermutationsOfWeaponSize() {
        return permutationsWeaponAndArmour.size();
    }

    public int getPermutationsOfRingsSize() {
        return permutationsOfRings.size();
    }

    public int getSizeOfAllPermutations() {
        return allPermutations.size();
    }

    public List<Item> getItemListAt(int i) {
        return allPermutations.get(i);
    }
}
