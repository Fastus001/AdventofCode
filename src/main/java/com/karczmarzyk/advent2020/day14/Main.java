package com.karczmarzyk.advent2020.day14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



public class Main {
    private final Pattern NUMBERS = Pattern.compile("(\\d+)");
    private List<String> inputList = new ArrayList<>();
    //part 1
    //    private   DockingData data = new DockingData();
    private  MemAddress address = new MemAddress();

    public void getInput() throws IOException {
        inputList = Files.readAllLines(Path.of("src/main/resources/2020/day14/day14.txt"));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.getInput();

        for(String s: main.inputList){
            if(s.contains("mask")){
                String[] split = s.split("mask = ");
//                main.data.setBitmaskMask(split[1]);
                main.address.setDecoderMask(split[1]);
            }else{
                List<Integer> collect = main.NUMBERS
                        .matcher(s)
                        .results()
                        .map(MatchResult::group)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
//                main.data.addToMemory(collect.get(0),collect.get(1));
                main.address.addToMemory(collect.get(0),collect.get(1));
            }
        }
//        long sumOfMem = main.data.getSumOfMem();
        long sumOfMem = main.address.getSumOfMem();
        System.out.println("sumOfMem = " + sumOfMem);
    }


}

