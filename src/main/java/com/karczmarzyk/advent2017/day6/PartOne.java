package com.karczmarzyk.advent2017.day6;

import java.util.ArrayList;
import java.util.List;

public class PartOne {

    public static void main(String[] args) {
        MemRoll memRoll = new MemRoll(new int[]{10,3,15,10,5,15,5,15,9,2,5,8,5,2,3,6});
        List<String> memoryBlocks = new ArrayList<>();
        memoryBlocks.add(memRoll.toStringStamp());

        int allocations = 0;
        while (true) {
            memRoll.reallocate();
            allocations++;
            String stamp = memRoll.toStringStamp();
            if(memoryBlocks.contains(stamp)){
                int cycles = howManyCycles(memoryBlocks, stamp);
                System.out.println("cycles = " + cycles);
                break;
            }else {
                memoryBlocks.add(stamp);
            }
        }
        System.out.println("allocations = " + allocations);
        //answer - 14029
        //answer part two - 2765
    }

    private static int howManyCycles(List<String> memoryBlocks, String stamp) {
        int index = 0;
        for (int i = 0; i < memoryBlocks.size(); i++) {
            if(stamp.equals(memoryBlocks.get(i))){
                index = i;
            }
        }
        return memoryBlocks.size()-index;
    }
}
