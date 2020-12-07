package com.karczmarzyk.advent2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputConverter {
    private final List<String> list = new ArrayList<>();

    public void getInput(String path)
    {
        try(var in = new Scanner( new File( path ) ))
        {
            var sb= new StringBuilder();
            while (in.hasNext())
            {
                String temp = in.nextLine();
                if(temp.length()!=0)
                    sb.append( temp )/*.append( " " ) turned off for day 6 2020*/;
                else
                {
                    list.add( sb.toString() );
                    sb.delete( 0,sb.length() );
                }
            }
            list.add( sb.toString() );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getListSize() {
        return list.size();
    }

    public void showList() {
        System.out.println( "list = " + list );
    }

    public List<String> getList() {
        return list;
    }
}