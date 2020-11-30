package com.karczmarzyk.advent2015.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task6Part2 {
    public int[][] tab;
    private ArrayList<String> inList;

    public Task6Part2()
    {
        tab = new int[1000][];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new int[1000];
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] =0;
            }
        }
    }

    public void getInput()
    {
        inList = new ArrayList<>();
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/task6input.txt")))
        {
            while(in.hasNext())
            {
                String line = in.nextLine();
                inList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setOff(int x, int y){
        tab[x][y]--;
        if(tab[x][y]<0)
            tab[x][y]=0;
    }

    private void setOn(int x, int y){tab[x][y]++;}

    private void toggle(int x, int y){tab[x][y]+=2; }

    public void parseString(String in)
    {
        String[] input = in.split("\\s");
        if(input.length == 4)
            toggleSquare(input);
        else
            turnOnOff(input);
    }

    private void turnOnOff(String[] input) {
        String[] start = input[2].split(",");
        String[] stop = input[4].split(",");
        int xStart = Integer.parseInt(start[0]);
        int yStart = Integer.parseInt(start[1]);
        int xStop = Integer.parseInt(stop[0]);
        int yStop = Integer.parseInt(stop[1]);

        if(input[1].equals("on"))
        {
            for (int y = yStart; y <=yStop ; y++) {
                for (int x = xStart; x <=xStop ; x++) {
                    setOn(x,y);
                }
            }
        }else{
            for (int y = yStart; y <=yStop ; y++) {
                for (int x = xStart; x <=xStop ; x++) {
                    setOff(x,y);
                }
            }
        }
    }

    private void toggleSquare(String[] input) {
        String[] start = input[1].split(",");
        String[] stop = input[3].split(",");
        int xStart = Integer.parseInt(start[0]);
        int yStart = Integer.parseInt(start[1]);
        int xStop = Integer.parseInt(stop[0]);
        int yStop = Integer.parseInt(stop[1]);
        for (int y = yStart; y <=yStop ; y++) {
            for (int x = xStart; x <=xStop ; x++) {
                toggle(x,y);
            }
        }
    }

    public static void main(String[] args) {
        Task6Part2 task = new Task6Part2();
        task.getInput();
        task.inList.forEach(task::parseString);
        long counter = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                counter+=task.tab[i][j];
            }
        }
        System.out.println("counter = " + counter);
        //System.out.println("task.tab = " + Arrays.deepToString(task.tab));

    }
}
