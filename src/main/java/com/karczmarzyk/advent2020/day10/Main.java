package com.karczmarzyk.advent2020.day10;

public class Main {

    public static void main(String[] args) {
        Adapters.getInput( "src/main/resources/2020/day10/day10.txt" );
        Adapters adapters = new Adapters();
        adapters.generateLists( 100 );

        System.out.println(adapters.getCounter());
    }
}
