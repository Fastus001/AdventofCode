package com.karczmarzyk.advent2020.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trajectory {
    private final List<String> list = new ArrayList<>();

    public int getTreeNumber(int x, int y)
    {
        int startX = 0;
        int counter = 0;
        for (int i = 1; i < list.size(); i+=y) {
             startX +=x;
            if( startX >list.get( i ).length()-1)
                startX -= list.get( i ).length();
            if(list.get( i ).charAt( startX ) == '#')
                counter++;
        }
        return counter;
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
