package com.karczmarzyk.advent2020.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class InputDataValidator {
    private static final Pattern NUMBER = Pattern.compile("(\\d+)");

    public List<Range> getListOfRanges(String path) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        List<Range> ranges = new ArrayList<>();
        for(String s:strings){
            int[] num = NUMBER.matcher(s)
                    .results()
                    .map(MatchResult::group)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ranges.add(new Range(num[0],num[1]));
            ranges.add(new Range(num[2],num[3]));
        }
        return ranges;
    }

    public List<int[]> getNearbyTickets(String path) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        List<int[]> temp = new ArrayList<>();
        for(String s:strings){
            temp.add(Arrays.stream(s.split(","))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray());
        }
        return temp;
    }


    public int[] getColumn(List<int[]> lines, int colNo){
        int[] temp = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            temp[i] = lines.get(i)[colNo];
        }
        return temp;
    }


}
