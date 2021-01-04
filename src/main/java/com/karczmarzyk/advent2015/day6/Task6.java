package com.karczmarzyk.advent2015.day6;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task6 {
    public boolean[][] tab;
    private ArrayList<String> inputList;

    public Task6()
    {
        tab = new boolean[1000][];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new boolean[1000];
        }
    }

    public void getInput()
    {
        inputList = new ArrayList<>();
        try(var in = new Scanner(new File("src/com/karczmarzyk/advent2015/resources/task6input.txt")))
        {
            while(in.hasNext())
            {
                String line = in.nextLine();
                inputList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setOff(int x, int y){tab[x][y] = false;}

    private void setOn(int x, int y){tab[x][y] = true;}

    private void toggle(int x, int y){tab[x][y] = !tab[x][y]; }

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
        Task6 task = new Task6();
        task.getInput();
        task.inputList.forEach(task::parseString);
        int counter = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(task.tab[i][j])
                    counter++;
            }
        }
        System.out.println("counter = " + counter);
        //System.out.println("task.tab = " + Arrays.deepToString(task.tab));

    }
}
