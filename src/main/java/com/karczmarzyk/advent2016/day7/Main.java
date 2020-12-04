package com.karczmarzyk.advent2016.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int result = Main.getInput();
        System.out.println( "result = " + result );
    }

    private static int getInput() {
        int counter = 0;
        try(var in = new Scanner( new File( "src/main/resources/2016/day7/day7.txt" ) ))
        {
//            IpvSeven ipvSeven = new IpvSeven();
            SslSupport support = new SslSupport();
            while (in.hasNext())
            {
//                if(ipvSeven.isIpCorrect(in.nextLine()))
//                    counter++;
                String temp = in.nextLine();
                if(support.isSslSupported(temp)){
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return counter;
    }
}
