package com.karczmarzyk.advent2020.day4;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputConverter converter = new InputConverter();
        converter.getInput( "src/main/resources/2020/day4/day4.txt" );
        List<String> list = converter.getList();
        int counter = 0;
        for(String s:list)
        {
            if(PassportValidator.validatePartTwo( s ))
                counter++;
        }
        System.out.println( "counter = " + counter );
    }
}
