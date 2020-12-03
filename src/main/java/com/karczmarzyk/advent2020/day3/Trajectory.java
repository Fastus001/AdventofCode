package com.karczmarzyk.advent2020.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trajectory {
    private List<String> list = new ArrayList<>();
    private int startX = 0;
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void traverse()
    {
        for (int i = 1; i < list.size(); i++) {
             startX +=3;
            if(startX>list.get( i ).length()-1)
                startX -= list.get( i ).length();
            if(list.get( i ).charAt( startX ) == '#')
                counter++;
        }
    }

    public void getInput(String path){
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext())
            {
                list.add( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
