package com.karczmarzyk.advent2020.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Instruction> list = getInput("src/main/resources/2020/day8/day8.txt");
        int step = 0;
        while (true){
            if(!list.get( step ).isVisited())
                step += list.get( step ).executeInstruction();
            else if(list.get( step ).isVisited()){
                System.out.println( "list.get( 0 ).getAccumulator() = " + list.get( 0 ).getAccumulator() );
                break;
            }
                
        }
        
    }

    private static List<Instruction> getInput(String path) {
        List<Instruction> temp = new ArrayList<>();
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext())
            {
                String[] split = in.nextLine().split( " " );
                temp.add( new Instruction( split[0], Integer.parseInt( split[1] ) ) );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
