package com.karczmarzyk.advent2016.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SquareThreeSides {

    public static void main(String[] args) {
        int result = SquareThreeSides.countTriangles();
        System.out.println( "result = " + result );
    }

    private static int countTriangles() {
        int counter = 0;
        try(var in = new Scanner( new File( "src/main/java/com/karczmarzyk/advent2016/resources/day3.txt") ))
        {
            while (in.hasNext())
            {
                if(Triangle.isItTriangle( in.nextLine() ))
                    counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
