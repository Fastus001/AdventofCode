package com.karczmarzyk.advent2020.day21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecipeTest {
    Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe( "mxmxvkd kfcds sqjhc nhms","dairy, fish)" );
    }

    @Test
    void testConstructor()
    {
        assertEquals( "mxmxvkd",recipe.getIngredients().get( 0 ) );
        assertEquals( "fish",recipe.getAllergens().get( 1 ) );
    }

    @Test
    void isIngredient() {
        assertTrue( recipe.isIngredient( "kfcds" ));
    }

    @Test
    void testIsIngredient() {
        assertTrue( recipe.isAllergen( "dairy" ) );
    }
}