package com.karczmarzyk.advent2015.Day15;

public class Ingredient {
    private final int capacity;
    private final int durability;
    private final int flavor;
    private final int texture;
    private final int calories;


    public Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.capacity = capacity;
        this.durability = durability;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
    }

    public long [] getIngredientScore(int num)
    {
        long [] tab = new long[5];
        tab[0] = capacity*num;
        tab[1] = durability*num;
        tab[2] = flavor*num;
        tab[3] = texture*num;
        tab[4] = calories*num;
        return tab;
    }
}
