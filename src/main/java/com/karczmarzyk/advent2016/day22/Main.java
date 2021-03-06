package com.karczmarzyk.advent2016.day22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static final Pattern NUM = Pattern.compile( "(\\d+)" );
    private static final List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> inputLines = Files.readAllLines( Path.of( "src/main/resources/2016/day22/input.txt" ) );

        for (String line : inputLines) {
            List<Integer> numbers = NUM.matcher( line ).results()
                    .map( MatchResult::group )
                    .map( Integer::parseInt )
                    .collect( Collectors.toList() );
            nodes.add( Node.builder().x( numbers.get( 0 )).y( numbers.get( 1 ))
                               .size( numbers.get( 2 ))
                               .used( numbers.get( 3 ))
                               .avail( numbers.get( 4 ))
                               .build()) ;
        }
        int counter = 0;
        for (Node node : nodes) {
            for (Node node1 : nodes) {
                if(node.getUsed()!=0 && !node.equals( node1 )){
                    if(node.getUsed()<node1.getAvail()){
                        counter++;
                    }
                }
            }
        }

        System.out.println( "counter = " + counter );
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 35; x++) {
                int finalY = y;
                int finalX = x;
                Node node = nodes.stream().filter( n -> n.getX() == finalX && n.getY() == finalY )
                        .findFirst()
                        .orElseThrow();
                if(node.getSize()>300){
                    System.out.print("x");
                }else if(node.getX()==0 && node.getY()==0){
                    System.out.print("!");
                }else if(node.getX()==34 && node.getY()==0){
                    System.out.print("G");
                }else if(node.getUsed()==0){
                    System.out.print("E");
                }else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }
}
