package com.karczmarzyk.advent2021.day3;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class BinaryDiagnostic {
    private List<String> input = new ArrayList<>();

    public int computePowerConsumtion() {
        var sb = new StringBuilder();
        for (int i = 0; i < input.get(0).length(); i++) {
            int result = 0;
            for (String s : input) {
                if (s.charAt(i) == '1') {
                    result++;
                } else {
                    result--;
                }
            }
            if (result > 0) sb.append("1");
            else sb.append("0");
        }
        String gammaRate = sb.toString();
        String epsilon = gammaRate.replace("0", "2")
                .replace("1", "0")
                .replace("2", "1");
        return Integer.parseInt(gammaRate,2) * Integer.parseInt(epsilon,2);
    }


}
