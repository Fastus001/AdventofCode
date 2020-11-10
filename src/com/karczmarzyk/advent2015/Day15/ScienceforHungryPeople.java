package com.karczmarzyk.advent2015.Day15;

import java.util.ArrayList;

public class ScienceforHungryPeople {
//    public static ArrayList<ArrayList<Integer>> PERMUTATIONS = new ArrayList<>();
    public static ArrayList<Long> PERMUTATIONS = new ArrayList<>();
    public static ArrayList<Long> RESULTS = new ArrayList<>();
    public  static Ingredient butterscotch = new Ingredient("Butterscotch",-1,-2,6,3,8);
    public  static Ingredient cinnamon = new Ingredient("Cinnamon",2,3,-2,-1,3);
    public  static Ingredient sprinkles = new Ingredient("Sprinkles",5,-1,0,0,5);
    public  static Ingredient peanutButter = new Ingredient("PeanutButter",-1,3,0,0,1);
    public  static Ingredient frosting = new Ingredient("Frosting",0,-1,4,0,6);
    public  static Ingredient sugar = new Ingredient("Sugar",-1,0,0,2,8);

    public static void main(String[] args) {
        getPermutations();
        System.out.println(" plum");


//        for(ArrayList<Integer> p: PERMUTATIONS)
//        {
//
//            long [] butScotch = butterscotch.getIngredientScore(p.get(0));
//            long [] cin = cinnamon.getIngredientScore(p.get(1));
//            long [] butter = sprinkles.getIngredientScore(p.get(2));
//            long [] peanut = peanutButter.getIngredientScore(p.get(3));
//            long [] frost = frosting.getIngredientScore(p.get(4));
//            long [] sug = sugar.getIngredientScore(p.get(5));
//            long [] result = sumArrays(butScotch,cin,butter,peanut,frost,sug);
//            Long aLong = result[0];
//            for (int i = 1; i < result.length; i++) {
//                aLong *=result[i];
//            }
//            RESULTS.add(aLong);
//        }
        Long max = PERMUTATIONS.stream().max(Long::compareTo)
                .orElse(0l);
        System.out.println("max = " + max);

        System.out.println("PERMUTATIONS = " + PERMUTATIONS.size());
    }

    private static long [] sumArrays(long [] a, long [] b, long[] c, long [] d, long [] e,long [] f)
    {
        long [] tab = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            tab[i] = a[i]+b[i]+c[i]+d[i]+e[i]+f[i];
            if(tab[i]<0)
                tab[i] = 0;
        }
        return tab;
    }

    private static void getPermutations() {
        for (int i = 1; i < 95; i++) {
            for (int j = 1; j < 95; j++) {
                if(i+j>96)
                    break;
                for (int k = 1; k < 95; k++) {
                    if(i+j+k>97)
                        break;
                    for (int l = 1; l < 95; l++) {
                        if(i+j+k+l>98)
                            break;
                        for (int m = 1; m < 95; m++) {
                            if(i+j+k+l+m>99)
                                break;
                            for (int n = 1; n < 95; n++) {
                                if(i+j+k+l+m+n>100)
                                    break;
                                if(i+j+k+l+m+n ==100)
                                {
                                    long [] butScotch = butterscotch.getIngredientScore(i);
                                    long [] cin = cinnamon.getIngredientScore(j);
                                    long [] butter = sprinkles.getIngredientScore(k);
                                    long [] peanut = peanutButter.getIngredientScore(l);
                                    long [] frost = frosting.getIngredientScore(m);
                                    long [] sug = sugar.getIngredientScore(n);
                                    long [] result = sumArrays(butScotch,cin,butter,peanut,frost,sug);
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
                }
            }
            System.out.println("i = " + i);
        }
    }
}
