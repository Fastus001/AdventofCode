package com.karczmarzyk.advent2016.day11;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class RtfValidator {


    public static boolean validateRtf(Rtf rtf){
        boolean test = true;
        List<Chip> mChips = rtf.getMChips();

        for (int i = 1; i <= 4; i++) {
            int finalI = i;
            var typeListMap = mChips.stream()
                    .filter( c -> c.getFloor() == finalI )
                    .collect( groupingBy( Chip::getType, toList() ) );

            if(typeListMap.size()>1){
                var microchips = typeListMap.get( Type.MICROCHIP );
                var generators = typeListMap.get( Type.GENERATOR );
                if(microchips.size()> generators.size()){
                    test = false;
                }else{
                    test = checkChipsAndGenerators( test, microchips, generators );
                }
            }
        }
        return test;
    }

    private static boolean checkChipsAndGenerators(boolean test, List<Chip> microchips, List<Chip> generators) {
        for (Chip m : microchips) {
            boolean isHavePair = false;
            for (Chip g : generators) {
                if ( m.getName().equals( g.getName() ) ) {
                    isHavePair = true;
                    break;
                }
            }
            if ( !isHavePair ) {
                test = false;
                break;
            }
        }
        return test;
    }
}
