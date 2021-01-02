package com.karczmarzyk.advent2020.day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Validator {
    private Map<String, Rule> ruleMap = new TreeMap<>();

    public Validator(String path) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        List<String[]> collect = strings.stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toList());
        collect.forEach(strings1 -> ruleMap.put(strings1[0],new Rule(strings1[1])));
    }

    public void checkMap(){
        for(Map.Entry<String,Rule> entry:ruleMap.entrySet()){
            Rule rule = entry.getValue();
            String key = entry.getKey();
            if(!rule.isOnlyLetters()){
                List<Integer> temp = rule.getNumber();
                temp = temp.stream()
                        .filter(integer -> integer>0)
                        .collect(Collectors.toList());
                if(temp.size()>0 ){
                    for(Integer in:temp) {
                        Rule rule1 = ruleMap.get(Integer.toString(in));
                        String num = "";
                        if(in>99){
                            num = Integer.toString(in);
                        }else{
                            num = " "+in+" ";
                        }
                        if(rule1.isOnlyLetters()){
//                    System.out.println("rule1 = " + rule1 + " " +num);
                            rule.addNewRules(rule1.getRulesFinalRules(),
                                    num);
//                            System.out.println("rule = " + rule + " key " + key);
                        }
                    }
                }
            }
        }
    }

    public Rule getRule(String key) {
        return ruleMap.get(key);
    }

    public int getRuleMapSize(){
        return ruleMap.size();
    }

    public Map<String, Rule> getRuleMap() {
        return ruleMap;
    }
}
