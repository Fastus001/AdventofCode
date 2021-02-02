package com.karczmarzyk.advent2016.day17;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class RoomLongest extends Room{
    private final Set<String > finishedList = new HashSet<>();

    @Override
    public String start(List<String> input) {
        List<String> resultList = getPossibleMoves( input );

        removeFinished( resultList );

        if(resultList.size()==0){
            return getResultMaxLength();
        }
        return start( resultList );
    }

    @NotNull
    private List<String> getPossibleMoves(List<String> input) {
        return input.stream()
                .map( this::testHashCode )
                .flatMap( Collection::stream )
                .map( this::testMove )
                .filter( s -> !s.contains( "false" ) )
                .collect( Collectors.toList() );
    }

    private void removeFinished(List<String> resultList) {
        Iterator<String> iterator = resultList.listIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.contains( "FINISH" )){
                finishedList.add( next.split( "-" )[0]);
                iterator.remove();
            }
        }
    }

    @NotNull
    private String getResultMaxLength() {
        return Integer.toString( finishedList.stream()
                                         .mapToInt( String::length )
                                         .max()
                                         .orElse( -1 ) );
    }
}
