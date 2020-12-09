package com.karczmarzyk.advent2020.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncodingError {
    private final int preamble;
    private final List<Long> list = new ArrayList<>();

    public EncodingError(int preamble) {
        this.preamble = preamble;
    }

    public void setList(String path) {
        try(var in = new Scanner( new File( path ) ))
        {
            while (in.hasNext()){
                list.add( in.nextLong() );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long getErrorNumber()
    {
        Permutations permutations = new Permutations( 2 );
        for (int i = preamble; i < list.size(); i++) {
            permutations.setNUMBERS( list.subList( i-preamble,i ));
            List<long[]> generate = permutations.generate();
            if(!isValid(generate, list.get( i ))){
                return list.get(i);
            }
        }
        return -1;
    }

    private boolean isValid(List<long[]> generate, long looking) {
        for(long[] longs:generate){
            if(longs[0]+longs[1] == looking){
                return true;
            }
        }
        return false;
    }

    public long findRange(long num){
        int range = 2;
        while (true){
            for (int i = 0; i < list.size(); i++) {
                long sum = 0;
                for (int j = 0; j < range; j++) {
                    if(i+j > list.size()-1)
                        break;
                    sum += list.get( i+j );
                }
                if(sum == num){
                    return getWeaknessNum( list.subList( i, i+range ));
                }
            }
            range++;
        }
    }

    private long getWeaknessNum(List<Long> subList) {
        Long min = subList.stream().min( Long::compareTo ).orElseThrow();

        final Long max = subList.stream().max( Long::compareTo ).orElseThrow();
        return min+max;
    }
}
