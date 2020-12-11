package com.karczmarzyk.advent2020.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputStringLines {

    public static List<String> getInput(String path){
        List<String> temp =  new ArrayList<>();
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext()){
                temp.add( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
