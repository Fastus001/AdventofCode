package com.karczmarzyk.advent2016.day16;

public class Main {

    public static void main(String[] args) {
        DataGen gen = new DataGen( 272 );

        String result = gen.generateChecksum( gen.generateData( "01111001100111011" ) );

        System.out.println( "result = " + result );
    }
}
