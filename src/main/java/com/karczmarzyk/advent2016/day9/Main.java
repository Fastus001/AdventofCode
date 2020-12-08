package com.karczmarzyk.advent2016.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String line = "";
        try(var in = new Scanner( new File( "src/main/resources/2016/day9/day9.txt" ) ))
        {
            line = in.nextLine();
        }
        Decompress decompress = new Decompress();
        decompress.decrypt( line );
        long size = decompress.getSize();

        Compress compress = new Compress();
        compress.decrypt( line );

        long part2 = compress.getSize();

        System.out.println( "size = " + size );

        System.out.println( "part2 = " + part2 );

    }
}
