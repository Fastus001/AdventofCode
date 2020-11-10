package com.karczmarzyk.advent2015.Day15;

public class Ingredient {
    private String name;
    private int capacity;
    private int durability;
    private int flavor;
    private int texture;
    private int calories;


    public Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
        this.name = name;
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
