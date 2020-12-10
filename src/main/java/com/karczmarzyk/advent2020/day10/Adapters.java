package com.karczmarzyk.advent2020.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adapters {
    private final int joltMax;
    private static final List<Integer> list = new ArrayList<>();
    private long counter = 0;

    public Adapters(int joltMax) {
        this.joltMax = joltMax;
        list.sort( Integer::compareTo );
    }


   public void generateLists(int lst){
       List<Integer> lists =  new ArrayList<>();
            if(lst== joltMax ){
                counter++;
                return;
            }
            for(Integer i:list){
                if(i-lst>0 && i-lst<4)                {
                    lists.add( i );
                }
            }
       for (Integer i:lists ) {
           generateLists( i );
       }
   }


   public static void getInput(String path){
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext()){
                list.add( in.nextInt() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
   }

    public long getCounter() {
        return counter;
    }
}
