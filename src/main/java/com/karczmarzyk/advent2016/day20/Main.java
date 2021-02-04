package com.karczmarzyk.advent2016.day20;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

public class Main {
    private static final long MAX = 4294967295L;

    public static void main(String[] args) throws IOException {
        List<String> allLines = Files.readAllLines( Path.of( "src/main/resources/2016/day20/input.txt" ) );

        List<IpRange> ranges = getIpRanges( allLines );

        while (ranges.size()>102){
            ranges = filterJoin( ranges );
        }
        ranges.sort( IpRange::compareTo );

        long result = 0;
        //we need to deduct one because both sides are inclusive to the firewall!!
        for (int i = 0; i < ranges.size()-1; i++) {
            result += (ranges.get( i+1 ).getMin()-ranges.get( i ).getMax())-1;
        }
        System.out.println( "result = " + result );

    }

    @NotNull
    private static List<IpRange> getIpRanges(List<String> allLines) {
        return allLines.stream()
                .map( s -> s.split( "-" ) )
                .map( strings -> new IpRange( parseLong( strings[0] ), parseLong( strings[1] ) ) )
                .collect( Collectors.toList() );
    }

    public static List<IpRange> filterJoin(List<IpRange> ranges){
        IpRange start = ranges.get( 0 );
        List<IpRange> temp = new ArrayList<>();
        for (int i = 1; i < ranges.size(); i++) {
            if(ranges.get( i ).isInRange( start )){
                start = start.joinRanges( ranges.get( i ) );
            }else{
                temp.add( ranges.get( i ) );
            }
        }
        temp.add( start );
        return temp;
    }


}
