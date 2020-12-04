package com.karczmarzyk.advent2016.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataInputFormatter {
    private final List<String> list = new ArrayList<>();
    private final Display display;

    public DataInputFormatter(Display display) {
        this.display = display;
    }

    public int checkArray()
    {
        for(String s:list)
        {
            if(s.contains( "rect" ))
                rectCommand( s );
            else{
                rotateCommands( s, s.contains( "row" ) );
            }
        }
        return display.getNumberOfLights();
    }

    private void rotateCommands(String in, boolean row)
    {
        String [] temp = in.split( "=" );
        String[] nums = temp[1].split( " by " );
        if(row)
        {
            display.rotateRow( Integer.parseInt( nums[0]),Integer.parseInt( nums[1] ) );
        }else{
            display.rotateColumn( Integer.parseInt( nums[0]),Integer.parseInt( nums[1] ) );
        }
    }

    private void rectCommand(String in)
    {
        String[] first = in.split( " " );
        String[] numbers = first[1].split( "x" );
        display.rect( Integer.parseInt( numbers[0] ), Integer.parseInt( numbers[1] ) );
    }

    public void getData(String path)
    {
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext())
            {
                list.add( in.nextLine() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void show()
    {
        display.showDisplay();
    }

}
