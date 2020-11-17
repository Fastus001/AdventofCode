package com.karczmarzyk.advent2015.Day19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MedicineTest {

    @Test
    public void test_Result_List_Replacement()
    {
        Replacement replacement = new Replacement( "HOH" );
        ArrayList<String> result = replacement.loadReplacements( "H", "HO" );
        System.out.println( "result = " + result );
    }

    @Test
    public void testInputDataFromTheTaskDescription()
    {
        ArrayList<String> result;
        Replacement replacement = new Replacement( "HOHOHO" );
        result = replacement.loadReplacements( "H", "HO" );
        result.addAll( replacement.loadReplacements( "H", "OH" ) );
        result.addAll( replacement.loadReplacements( "O", "HH" ) );
        assertEquals(7 ,result.stream().distinct().count() );
    }

    @Test
    public void testMedicineClassInputMethod()
    {
        Medicine medicine = new Medicine();
        medicine.getInput();
        assertEquals( 43,medicine.getInputListSize() );
    }

    @Test
    public void testSplitInputStrings()
    {
        Medicine medicine = new Medicine();
        medicine.getInput();
        String[] split = medicine.getListItem( 0 ).split( " => " );
        assertEquals( "Al",split[0] );
        assertEquals( "ThF",split[1] );
    }


}