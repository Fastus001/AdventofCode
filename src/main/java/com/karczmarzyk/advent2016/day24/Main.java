package com.karczmarzyk.advent2016.day24;

import com.karczmarzyk.advent2016.day13.MazeGenerator;
import com.karczmarzyk.utils.Generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int MIN = 2000;
    private static String[] numbers = new String[]{"1", "2", "3", "4", "5", "6", "7"};
    private static MazeSolverAdv solverAdv;

    public static void main(String[] args) throws IOException {
        MazeGenerator generator = new MazeGenerator(
                Files.readAllLines( Path.of( "src/main/resources/2016/day24/input.txt" ) ) );
        solverAdv = new MazeSolverAdv( generator.getMaze() );

        Generator.generatePermutation( 7, numbers );
        ArrayList<List<String>> permutations = Generator.PERMUTATIONS;
        int minNumberOfMoves = permutations.stream()
                .filter( lst->lst.get( 0 ).equals( "1" ) )
                .filter( lst->lst.get( 1 ).equals( "7" ) )
                .mapToInt( Main::solveMaze )
                .min()
                .orElse( -1 );
        System.out.println(minNumberOfMoves);

    }

    public static int solveMaze(List<String> waypoints){
        int sum = 0;
        solverAdv.setStart( '0' );
        solverAdv.setEnd( waypoints.get( 0 ).charAt( 0 ) );
        sum+=solverAdv.start();
        for (int i = 1; i < waypoints.size(); i++) {
            solverAdv.setStart( waypoints.get( i-1 ).charAt( 0 ) );
            solverAdv.setEnd( waypoints.get( i ).charAt( 0 ) );
            sum+=solverAdv.start();
            if(sum>MIN){
                System.out.println( waypoints + " --- " + sum);
                return 2000;
            }
        }
        //part two ///
        solverAdv.setStart( waypoints.get( waypoints.size()-1 ).charAt( 0 ) );
        solverAdv.setEnd( '0' );
        sum+=solverAdv.start();
        ///////
        if(sum<MIN){
            MIN = sum;
        }
        System.out.println( waypoints + " --- " + sum);
        return sum;
    }
}
