package com.karczmarzyk.advent2015.Day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuringLock {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        TuringLock tLock = new TuringLock();
        tLock.getInputData();
        Register regA = new Register();
        Register regB = new Register();
        for (int i = 0; i < list.size(); ) {
            if(list.get( i ).contains( "a" ))
                i = regA.executeInstruction( list.get( i ),i );
            else
                i = regB.executeInstruction( list.get( i ),i );
            System.out.println( "i = " + i );
        }
        System.out.println( "regA.getA() = " + regA.getA() );
        System.out.println( "regB = " + regB.getA() );

    }

    private void getInputData() {
        try(var in = new Scanner( new File("src/com/karczmarzyk/advent2015/resources/day23.txt") ))
        {
            while(in.hasNext())
            {
                list.add( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
