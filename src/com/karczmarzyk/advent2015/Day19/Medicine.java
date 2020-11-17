package com.karczmarzyk.advent2015.Day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Medicine {
    private final ArrayList<String> inputList = new ArrayList<>();
    private Replacement replacement = new Replacement( "CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl" );;


    public static void main(String[] args) {
        Medicine medicine = new Medicine();
        medicine.getInput();

        System.out.println( "medicine = " + medicine.getResult() );

    }

    private long getResult()
    {
        ArrayList<String> resultList = new ArrayList<>();
        for(String s: inputList)
        {
            String [] split = s.split( " => " );
            resultList.addAll( replacement.loadReplacements( split[0],split[1] ) );
        }
        return resultList.stream().distinct().count();
    }

    public void getInput() {
        try(Scanner in = new Scanner( new File( "src/com/karczmarzyk/advent2015/resources/day19.txt") ))
        {
           while(in.hasNext())
           {
            inputList.add( in.nextLine() );
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getInputListSize() {
        return inputList.size();
    }

    public String getListItem(int i) {
        return inputList.get( i );
    }
}
