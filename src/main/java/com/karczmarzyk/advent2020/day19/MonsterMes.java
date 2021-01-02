package com.karczmarzyk.advent2020.day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MonsterMes {

    public static void main(String[] args) throws IOException {
        Validator validator = new Validator("src/main/resources/2020/day19/rules.txt");
        validator.checkMap();
        validator.checkMap();
        validator.checkMap();
        validator.checkMap();
        validator.checkMap();
        List<String> rules42 = validator.getRule("42").getRulesFinalRules();
        List<String> rules31 = validator.getRule("31").getRulesFinalRules();
        System.out.println("rules31.size() = " + rules31.size());
        System.out.println("rules42.size() = " + rules42.size());
        List<String> messages = Files.readAllLines(Path.of("src/main/resources/2020/day19/messages.txt"));
        messages = messages.stream()
                    .filter(s -> s.length()==24)
                    .collect(Collectors.toList());

//        filterRules(rules42, messages,true);
//        filterRules(rules31,messages,false);

        System.out.println("rules31.size() after= " + rules31.size());
        System.out.println("rules42.size() after= " + rules42.size());
        List<String> result = new ArrayList<>();
        int counter = 0;
//        for(String r:rules42){
//             for(String r2:rules42) {
//                 for (String r3 : rules31) {
//                     for (String m : messages) {
//                         if ((m).equals(r+r2+r3)) {
//                             result.add(m);
//                             counter++;
//                         }
//                     }
//                 }
//             }
//        }
        for(String m:messages){
            for(String r:rules42){
                for(String r1:rules42){
                    for(String r2:rules31){
                        if(m.equals(r+r1+r2)){
                            counter++;
                            result.add(m);
                        }

                    }
                }
            }
        }
        result = result.stream().distinct().collect(Collectors.toList());
        System.out.println("result = " + result.size());
        System.out.println(messages.size());
        System.out.println("counter" + counter);
    }

    private static void filterRules(List<String> rules, List<String> messages, boolean start) {
        Iterator<String> iterator = rules.listIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            long count;
            if(start){
                count = messages.stream()
                        .filter(s -> s.startsWith(next))
                        .count();
            }else{
                count = messages.stream()
                        .filter(s -> s.startsWith(next,16))
                        .count();
            }
            if(count==0){
                iterator.remove();
            }
        }
    }
}
