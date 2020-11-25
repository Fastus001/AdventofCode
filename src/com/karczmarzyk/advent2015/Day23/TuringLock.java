package com.karczmarzyk.advent2015.Day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuringLock {
    private static final List<String> LIST = new ArrayList<>();

    public static void main(String[] args) {
        TuringLock tLock = new TuringLock();
        tLock.getInputData();
        Register regA = new Register();
        //part 2 only change
        regA.setRegisterNumber( 1);
        Register regB = new Register();
        for (int i = 0; i < LIST.size(); ) {
            if( LIST.get( i ).contains( "a" ))
                i = regA.executeInstruction( LIST.get( i ), i );
            else
                i = regB.executeInstruction( LIST.get( i ), i );
            System.out.println( "i = " + i );
        }
        System.out.println( "regA.getRegisterNumber() = " + regA.getRegisterNumber() );
        System.out.println( "regB = " + regB.getRegisterNumber() );

    }

    private void getInputData() {
        try(var in = new Scanner( new File("src/com/karczmarzyk/advent2015/resources/day23.txt") ))
        {
            while(in.hasNext())
            {
                LIST.add( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
