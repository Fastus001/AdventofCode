package com.karczmarzyk.advent2016.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecurityObscurity {

    public static void main(String[] args) {
        int sum = getInput();
        System.out.println( "sum = " + sum );
    }

    private static int getInput() {
        int sum = 0;
        try(var in = new Scanner( new File( "src/main/java/com/karczmarzyk/advent2016/resources/day4.txt" ) ))
        {
            while (in.hasNext())
            {
//                Room room = new Room( in.nextLine() );
//                sum+= room.getID();
                RoomCipher room = new RoomCipher( in.nextLine() );
                String test = room.decipher();
                System.out.println( "test + room.getID() = " + test + room.getID() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
