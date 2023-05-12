package com.karczmarzyk.advent2017.day6;

import java.util.Arrays;

public class MemRoll {

    private final int [] blocks;

    public MemRoll(int[] blocks) {
        this.blocks = blocks;
    }


    public String toStringStamp() {
        return Arrays.toString(blocks);
    }

    public void reallocate() {
        int memoryBank = 0;
        int max = 0;
        for (int i = 0; i < blocks.length; i++) {
            if(blocks[i]>max){
                memoryBank = i;
                max = blocks[i];
            }
        }
        blocks[memoryBank]=0;
        for (int i = memoryBank+1; i <= blocks.length; i++) {
            if(i == blocks.length){
                i = 0;
            }
            blocks[i]++;
            max--;
            if(max == 0){
                break;
            }
        }
    }
}
