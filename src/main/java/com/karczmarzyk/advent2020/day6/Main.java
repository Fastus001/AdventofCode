package com.karczmarzyk.advent2020.day6;

import com.karczmarzyk.advent2020.day4.InputConverter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputConverter converter = new InputConverter();
        converter.getInput( "src/main/resources/2020/day6/day6.txt" );
        List<String> list = converter.getList();
        int partOne = 0;
        int partTwo = 0;
        for(String s:list)
        {
            partOne += Custom.countCustomQuestions( s );
            partTwo +=CustomAdvanced.getInput( s );
        }
        System.out.println( "partOne = " + partOne );
        System.out.println( "partTwo = " + partTwo );
    }
}
