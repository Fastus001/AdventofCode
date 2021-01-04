package com.karczmarzyk.advent2020.day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Validator {
    private final Map<Integer, Rule> ruleMap = new HashMap<>();
    private final List<String> messages;

    public Validator(String path) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));

        List<String[]> rules = strings.stream()
                .filter( s -> s.contains( ":" ) )
                .map(s -> s.split(":"))
                .collect(Collectors.toList());

        rules.forEach(strings1 -> ruleMap
                .put( parseInt( strings1[0]), new Rule( strings1[1],this)));

        messages = strings.stream()
                .filter( s -> !s.contains( ":" ) && s.length()!=0 )
                .collect( Collectors.toList());
    }

    public int checkMessagesPartOne(){
        //42
        String rule8 = this.getRule( 8 ).getRule();
        //42 31
        String rule11 = this.getRule( 11 ).getRule();

        Pattern pattern = Pattern.compile( rule8+rule11 );

        int counter = getNumberOfMatches( pattern );
        System.out.println( "count = " + counter );
        return counter;
    }

    private int getNumberOfMatches(Pattern pattern) {
        int counter = 0;
        for(String s:messages){
            Matcher matcher = pattern.matcher( s);
            if(matcher.matches()){
                counter++;
            }
        }
        return counter;
    }

    public Rule getRule(Integer key) {
        return ruleMap.get(key);
    }

    public int getRuleMapSize(){
        return ruleMap.size();
    }

    public List<String> getMessages() {
        return messages;
    }
}
