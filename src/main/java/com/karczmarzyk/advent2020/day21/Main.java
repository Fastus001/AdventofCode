package com.karczmarzyk.advent2020.day21;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static  Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines( Path.of( "src/main/resources/2020/day21/day21.txt" ) );
        List<Recipe> recipes = getRecipeList( strings );
        List<String> collect = recipes.stream().map( Recipe::getAllergens )
                .flatMap( Collection::stream )
                .distinct()
                .collect( Collectors.toList() );

        result = new TreeSet<>();
        for (String s : collect) {
            result.addAll( Allergen.getAllergens( s,getRecipeList( strings ) ) );
        }
        System.out.println( "temp = " + result ) ;

        long count = recipes.stream().map( r -> r.getIngredients() )
                .flatMap( i -> i.stream() )
                .filter( Main::test )
                .count();
        System.out.println( "count = " + count );
    }

    public static boolean test(String s){
        return !result.contains( s );
    }

    @NotNull
    private static List<Recipe> getRecipeList(List<String> strings) {
        List<Recipe> recipes = new ArrayList<>();
        for (String s : strings) {
            String[] split = s.split( "\\(contains " );
            recipes.add( new Recipe( split[0],split[1] ) );
        }
        return recipes;
    }
}
