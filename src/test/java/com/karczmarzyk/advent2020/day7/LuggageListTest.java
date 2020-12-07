package com.karczmarzyk.advent2020.day7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LuggageListTest {

    LuggageList list;

    @BeforeEach
    void setUp() {

    }

    @Test
    void checkList() {
        list = new LuggageList( getList() );
        list.checkList( "shiny gold" );
        assertEquals( 169,list.getNumberOfLuggageContainingShinyGold() );
    }

    @Test
    void checkListNumber() {
        list = new LuggageList( getList() );
        list.checkList( "shiny gold" );
        list.luggageNumber();
        assertEquals( 82372,list.getGoldLuggageNumber() );
    }

    public List<Luggage> getList()
    {
        List<Luggage> lst = new ArrayList<>();
        try(var in = new Scanner( new File( "src/main/resources/2020/day7/day7.txt" ) ))
        {
            while (in.hasNext())
            {
                lst.add( new Luggage( in.nextLine() ));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lst;
    }

}