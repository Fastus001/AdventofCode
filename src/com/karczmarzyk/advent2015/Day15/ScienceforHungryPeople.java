package com.karczmarzyk.advent2015.Day15;

import java.util.ArrayList;

public class ScienceforHungryPeople {
//    public static ArrayList<ArrayList<Integer>> PERMUTATIONS = new ArrayList<>();
    public static ArrayList<Long> PERMUTATIONS = new ArrayList<>();
    public static ArrayList<Long> RESULTS = new ArrayList<>();
//    public  static Ingredient butterscotch = new Ingredient("Butterscotch",-1,-2,6,3,8);
//    public  static Ingredient cinnamon = new Ingredient("Cinnamon",2,3,-2,-1,3);
    public  static Ingredient sprinkles = new Ingredient("Sprinkles",5,-1,0,0,5);
    public  static Ingredient peanutButter = new Ingredient("PeanutButter",-1,3,0,0,1);
    public  static Ingredient frosting = new Ingredient("Frosting",0,-1,4,0,6);
    public  static Ingredient sugar = new Ingredient("Sugar",-1,0,0,2,8);

    public static void main(String[] args) {
        getPermutations();
        System.out.println(" plum");

        Long max = PERMUTATIONS.stream().max(Long::compareTo)
                .orElse(0l);
        System.out.println("max = " + max);

        System.out.println("PERMUTATIONS = " + PERMUTATIONS.size());
    }

    private static long [] sumArrays(long [] a, long [] b, long[] c, long [] d)
    {
        long [] tab = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            tab[i] = a[i]+b[i]+c[i]+d[i];
            if(tab[i]<0)
                tab[i] = 0;
        }
        return tab;
    }

    private static void getPermutations() {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    for (int l = 0; l < 101; l++) {
                        if(i+j+k+l ==100)
                        {
                            long [] butter = sprinkles.getIngredientScore(i);
                            long [] peanut = peanutButter.getIngredientScore(j);
                            long [] frost = frosting.getIngredientScore(k);
                            long [] sug = sugar.getIngredientScore(l);
                            long [] result = sumArrays(butter,peanut,frost,sug);
                            Long aLong = result[0];
                            //TODO - jest minus jeden ¿e niby bez kalorii narazie policzyæ
                            //TODO - plus sprawdziæ tylko cztery sk³adniki,
                            for (int x = 1; x < result.length-1; x++) {
                                aLong *=result[x];
                            }
                            PERMUTATIONS.add(aLong);
                        }
                    }
                }
            }
            System.out.println("i = " + i);
        }
    }
}
