package com.karczmarzyk.advent2016.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BathroomSecurity {

/*
Part 1 - output goes to the Integer list
Part 2 - output goes to the String
 */
    public static void main(String[] args) {
        List<String> input = BathroomSecurity.getInput();
        PinPad2 pinPad2 = new PinPad2();
        String password = "";
        for(String s: input)
        {
                password = password.concat( pinPad2.getString( s ));
        }
        System.out.println( "password = " + password);
    }

    private static List<String> getInput() {
        List<String> lst = new ArrayList<>();
        try(var in = new Scanner(new File( "src/com/karczmarzyk/advent2016/resources/day2.txt" )))
        {
            while (in.hasNext())
            {
                lst.add( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lst;
    }
}
