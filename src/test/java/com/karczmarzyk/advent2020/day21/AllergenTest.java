package com.karczmarzyk.advent2020.day21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AllergenTest {
    List<String> allergens;
    List<Recipe> recipes;

    @BeforeEach
    void setUp() throws IOException {
        List<String> strings = Files.readAllLines( Path.of( "src/main/resources/2020/day21/day21.txt" ) );
        recipes = new ArrayList<>();
        for (String s : strings) {
            String[] split = s.split( "\\(contains " );
            recipes.add( new Recipe( split[0],split[1] ) );
        }
    }

    @Test
    void checkAllergen() {
        allergens = Allergen.getAllergens( "eggs",  recipes);
        assertEquals( "gtqfrp",allergens.get( 0 ) );
    }
}