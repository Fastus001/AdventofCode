package com.karczmarzyk.advent2020.day6;

import com.karczmarzyk.advent2020.day4.InputConverter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputConverter converter = new InputConverter();
        converter.getInput( "src/main/resources/2020/day6/day6.txt" );
        List<String> list = converter.getList();
        int sum = 0;
        for(String s:list)
        {
            sum += Custom.countCustomQuestions( s );
        }
        System.out.println( "sum = " + sum );
    }
}
