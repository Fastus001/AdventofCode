package com.karczmarzyk.advent2015.day19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplacementTest {

    @Test
    public void test_Result_List_Replacement()
    {
        Replacement replacement = new Replacement( "HOH" );
        replacement.loadReplacements( "H", "e" );
        assertEquals( 2,replacement.getNumberOfOccurrences() );
    }

    @Test
    public void tesResultClassMultipleOccurrences()
    {
        Replacement replacement = new Replacement( "CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl" );
        replacement.loadReplacements( "CaCa", "Ca" );
        assertEquals( 10,replacement.getNumberOfOccurrences() );
    }

    @Test
    public void testCoupleReplacementCount()
    {
        Replacement replacement = new Replacement( "HOH" );
        replacement.loadReplacements( "HO", "H" );
        replacement.loadReplacements( "HH", "O" );
        replacement.loadReplacements( "O", "e" );
        assertEquals( 3,replacement.getNumberOfOccurrences() );
    }

    @Test
    public void testIfTextHasDoubleSmallE()
    {
        Replacement replacement = new Replacement( "eOe" );

        assertTrue( replacement.isDoubleE());

        Replacement onlyOne_e = new Replacement( "eO" );

        assertFalse( onlyOne_e.isDoubleE() );
    }






}