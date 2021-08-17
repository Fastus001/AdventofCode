package com.karczmarzyk.advent2017.day15;

import lombok.Data;

@Data
public class Judge {
    private final Generator genA;
    private final Generator genB;

    public Judge(Generator genA, Generator genB) {
        this.genA = genA;
        this.genB = genB;
    }


    public boolean isLowestBitsSame() {
        int minLengthA = 16;
        int minLengthB = 16;
        String nextAValue = genA.onNext();
        String nextBValue = genB.onNext();
        int lengthA = nextAValue.length();
        if(lengthA < minLengthA){
            minLengthA = lengthA;
        }
        int lengthB = nextBValue.length();
        if(lengthB < minLengthB) {
            minLengthB = lengthB;
        }
        String subA = nextAValue.substring(lengthA - minLengthA, lengthA);
        String subB = nextBValue.substring(lengthB - minLengthB, lengthB);

        return subA.equals(subB);
    }
}
