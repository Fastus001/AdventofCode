package com.karczmarzyk.advent2016.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartOne {
    private static List<Rtf> RTFS  = new ArrayList<>();

    public PartOne(List<Rtf> rtfList) {
        this.RTFS = rtfList;
    }

    public void makeMove(){
        List<Rtf> temp = new ArrayList<>();
        for (Rtf rtf : RTFS) {
            temp.addAll( rtf.generatePossibleMoves() );
        }
        for (Rtf r : temp) {
//            System.out.println(r.getFloorSum() + " " + r.toString());
        }
        int max = temp.stream().mapToInt( Rtf::getFloorSum ).max().orElse( -1 );
        System.out.println("max: "+ max);

        System.out.println(temp.size());
        RTFS.clear();
        RTFS = temp.stream()
                .distinct()
                .filter( RtfValidator::validateRtf )
                .collect( Collectors.toList());

    }



}
