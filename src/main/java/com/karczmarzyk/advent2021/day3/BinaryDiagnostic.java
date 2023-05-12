package com.karczmarzyk.advent2021.day3;

import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Setter
public class BinaryDiagnostic {
    private List<String> input = new ArrayList<>();

    public int computePowerConsumption() {
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
        return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilon, 2);
    }

    public List<String> bitCriteria(List<String> input, int index, boolean mostCommon) {
        if(input.size()==1)
            return input;
        int result = 0;
        for (String s : input) {
            if (s.charAt(index) == '1') {
                result++;
            } else {
                result--;
            }
        }
        List<String> afterFiltering;
        if (mostCommon){
            afterFiltering = mostCommon(input, index, result);
        } else {
            afterFiltering = leastCommon(input, index, result);
        }
        return bitCriteria(afterFiltering, ++index, mostCommon);
    }

    @NotNull
    private List<String> mostCommon(List<String> input, int index, int result) {
        if(result >=0){
            return input.stream()
                    .filter(s -> s.charAt(index) == '1')
                    .collect(toList());
        } else {
            return input.stream()
                    .filter(s -> s.charAt(index) == '0')
                    .collect(toList());
        }
    }

    @NotNull
    private List<String> leastCommon(List<String> input, int index, int result) {
        if(result >= 0){
            return input.stream()
                    .filter(s -> s.charAt(index) == '0')
                    .collect(toList());
        } else {
            return input.stream()
                    .filter(s -> s.charAt(index) == '1')
                    .collect(toList());
        }
    }


}
