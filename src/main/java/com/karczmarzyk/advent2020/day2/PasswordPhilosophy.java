package com.karczmarzyk.advent2020.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordPhilosophy {

    public static void main(String[] args) {
        int result = getInputData();
        System.out.println( "result = " + result );
    }

    private static int getInputData() {
        int sum = 0;
        try(var in = new Scanner( new File( "src/main/resources/2020/day2.txt" ) ))
        {
            while (in.hasNext())
            {
                Password password = new Password( in.nextLine() );
                if( password.isPasswordValid() )
                    sum++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
