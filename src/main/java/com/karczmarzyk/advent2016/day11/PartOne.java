package com.karczmarzyk.advent2016.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {
    private static List<Rtf> RTF_LIST = new ArrayList<>();

    public PartOne(List<Rtf> rtfList) {
        this.RTF_LIST = rtfList;
    }

    public void makeMove(){
        List<Rtf> temp = new ArrayList<>();
        for (Rtf rtf : RTF_LIST) {
            temp.addAll( rtf.generatePossibleMoves() );
        }

        RTF_LIST.clear();
        RTF_LIST = temp.stream()
                .distinct()
                .filter( RtfValidator::validateRtf )
                .collect( Collectors.toList());

    }



}
