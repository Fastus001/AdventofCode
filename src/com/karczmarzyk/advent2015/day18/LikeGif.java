package com.karczmarzyk.advent2015.day18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LikeGif {
    private final ArrayList<String> list = new ArrayList<>();
    private boolean[][] tab;

    public static void main(String[] args) {
        LikeGif likeGif = new LikeGif();
        for (int i = 0; i < 100; i++) {
            likeGif.updateLights();
        }
        System.out.println("likeGif.numbersOfLights() = " + likeGif.numbersOfLights());
    }

    public LikeGif()
    {
        input();
        int size =list.size();
        tab = getBooleansArray(size);
        for (int i = 0; i < size; i++) {
            char[] chars = list.get(i).toCharArray();
            for (int k = 0; k < size; k++) {
                tab[i][k] = chars[k] != '.';
            }
        }
    }

    private boolean[][] getBooleansArray(int size) {
        final boolean[][] tab;
        tab = new boolean[size][];
        for (int i = 0; i < size; i++) {
            tab[i] = new boolean[size];
        }
        return tab;
    }

    public int numbersOfLights()
    {
        int counter = 0;
        for (boolean[] booleans : tab) {
            for (int k = 0; k < tab.length; k++) {
                if (booleans[k])
                    counter++;
            }
        }
        return counter;
    }
    
    public void showList()
    {
        for (boolean[] booleans : tab) {
            for (int k = 0; k < tab.length; k++) {
                if(booleans[k])
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void input() {
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/day18.txt")))
        {
            while(in.hasNext())
            {
                var s = in.nextLine();
                list.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int checkFieldLighOn(int x, int y) {
        if(x<0 || x >= tab.length || y < 0 || y >= tab.length)
            return 0;
        else if(tab[x][y])
                return 1;
        return 0;
    }

    public int countNeighborsLightOn(int x, int y) {
        if(x<0 || x >= tab.length || y < 0 || y >= tab.length)
            return 0;
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            sum += checkFieldLighOn(x-1,y-i);
            sum += checkFieldLighOn(x+1,y-i);
        }
        sum += checkFieldLighOn(x,y+1);
        sum += checkFieldLighOn(x,y-1);
        return sum;
    }

    public void updateLights() {
        boolean[][] temp = getBooleansArray(tab.length);
        for (int i = 0; i < tab.length; i++) {
            for (int k = 0; k < tab.length; k++) {
                int lightsOn = countNeighborsLightOn(i,k);
                if(tab[i][k] && (lightsOn==2 || lightsOn==3))
                    temp[i][k] = true;
                if(!tab[i][k] && lightsOn==3)
                    temp[i][k] = true;
            }
        }
        //Part 2 - all corners are alway "on"
        temp[0][0] = true;
        temp[0][temp.length-1]  = true;
        temp[temp.length-1][0] = true;
        temp[temp.length-1][temp.length-1]  = true;
        tab = temp;
    }
}
