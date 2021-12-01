package com.karczmarzyk.advent2021.day1;

import java.util.ArrayList;
import java.util.List;

public class SonarSweep {

    public static int countDepthIncrease(int[] report) {
        int counter = 0;
        int current = 0;
        for (int j : report) {
            if (current < j) {
                counter++;
            }
            current = j;
        }
        return --counter;
    }

    public static int [] convertToThreeMeasurement(int [] report) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < report.length-2; i++) {
            int sum = 0;
            for (int x = 0; x < 3; x++) {
                sum += report[i+x];
            }
            temp.add(sum);
        }
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}
