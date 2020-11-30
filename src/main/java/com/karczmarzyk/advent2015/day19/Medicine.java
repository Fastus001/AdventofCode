package com.karczmarzyk.advent2015.day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Medicine {
    private final ArrayList<String> inputList = new ArrayList<>();
    private final Replacement replacement = new Replacement( "CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl" );

/*
Note: no need to add last three input lines, as this could obscure the results.
 */
    public static void main(String[] args) {
        Medicine medicine = new Medicine();
        medicine.getInput();
        while(medicine.replacement.textSize()>2)
        {
            medicine.getResult();
        }
        System.out.println("Number of steps needed to make medicine is " + (medicine.replacement.numberOfOccurrences+1));
    }


    private void getResult()
    {
        for(String s: inputList)
        {
            String [] split = s.split( " => " );
            replacement.loadReplacements( split[1],split[0] );
        }
    }

    public void getInput() {
        try(Scanner in = new Scanner( new File( "src/com/karczmarzyk/advent2015/resources/day19part2.txt") ))
        {
           while(in.hasNext())
           {
            inputList.add( in.nextLine() );
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
