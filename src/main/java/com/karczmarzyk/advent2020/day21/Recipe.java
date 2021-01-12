package com.karczmarzyk.advent2020.day21;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Recipe {
    private List<String> ingredients = new ArrayList<>();
    private List<String> allergens;

    public Recipe(String first, String second) {
        String[] s = first.split( " " );
        ingredients.addAll( Arrays.asList( s ) );
        String[] split = second.replace( ")", "" ).split( "," );
        allergens = Arrays.stream( split )
                .map( String::trim )
                .collect( Collectors.toList() );
    }

    public boolean isIngredient(String ingredient){
        return ingredients.contains( ingredient );
    }

    public boolean isAllergen(String allergen){
        return allergens.contains( allergen );
    }

}
