package com.karczmarzyk.advent2020.day21;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Allergen {

    public static List<String> getAllergens(String allergen, List<Recipe> recipes ) {

        List<Recipe> recipesWithAllergen = recipes.stream()
                .filter( r -> r.getAllergens().contains( allergen ) )
                .collect( Collectors.toList() );

        for (Recipe rec : recipesWithAllergen) {
            List<String> good = goodIngredients( recipesWithAllergen, rec.getIngredients() );
            for (String s : good) {
                for (Recipe recipe : recipesWithAllergen) {
                    if ( recipe.isIngredient( s ) ) {
                        recipe.getIngredients().remove( s );
                    }
                }
            }
        }
        return recipesWithAllergen.stream().map( Recipe::getIngredients )
                .flatMap( Collection::stream )
                .distinct()
                .collect( Collectors.toList() );
    }


    public static List<String> goodIngredients(List<Recipe> recipes, List<String> look) {
        List<String> temp = new ArrayList<>();
        for (String s : look) {
            for (Recipe r : recipes) {
                if ( !r.isIngredient( s ) ) {
                    temp.add( s );
                    break;
                }
            }
        }
        return temp;
    }
}

@AllArgsConstructor
@Data
class Pair {
    private String ingredient;
    private int quantity;
}
