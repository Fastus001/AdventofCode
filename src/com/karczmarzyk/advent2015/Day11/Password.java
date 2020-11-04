package com.karczmarzyk.advent2015.Day11;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Password {
    public static final Pattern DBL_LETTER = Pattern.compile("(.)\\1");
    public static final  List<String> ALPHABET =
            new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q",
            "r","s","t","u","v","w","x","y","z"));
    public List<Integer>NUMBERS = new ArrayList<>();

    public Password(String input){mapLetters(input);}

    public void increaseByOne(int row)
    {
        int num = NUMBERS.get(row);
        if(num == ALPHABET.size()-1)
        {
            num = 0;
            NUMBERS.set(row,num);
            increaseByOne(row-1);
        }else{
            NUMBERS.set(row,num+1);
        }
    }

    public boolean isNotOk()
    {
        boolean check;
        check = this.isDoublePresent(this.isThreeConsecutiveLetters());
        return this.isIOLPresent(check);
    }

    private boolean isThreeConsecutiveLetters()
    {
        int count = 1;
        int num = NUMBERS.get(0);
        for (int i = 1; i < NUMBERS.size(); i++) {
            if(NUMBERS.get(i)==(num+1))
            {
                count++;
                num = NUMBERS.get(i);
            }
            else{
                count = 1;
                num = NUMBERS.get(i);
            }
            if(count==3)
                return true;
        }
        return false;
    }

    private boolean isDoublePresent(boolean isTrue)
    {
        if(isTrue)
        {
            Set<String> collect = DBL_LETTER.matcher(this.getPassword())
                    .results().map(MatchResult::group)
                    .collect(Collectors.toSet());
            return collect.size()>1;
        }else{
            return false;
        }
    }

    private boolean isIOLPresent(boolean isTrue)
    {
        if(isTrue)
            return NUMBERS.stream()
                    .noneMatch(integer -> integer==8 || integer==11 || integer==14);
        else
            return false;
    }

    public String getPassword()
    {
        StringBuilder sb = new StringBuilder();
        for (Integer number : NUMBERS) {
            sb.append(ALPHABET.get(number));
        }
        return sb.toString();
    }

    private void mapLetters(String input) {
        String ch;
        for (int i = 0; i < input.length(); i++) {
            ch = input.substring(i,i+1);
            for (int j = 0; j < ALPHABET.size(); j++) {
                if(ch.equals(ALPHABET.get(j)))
                    NUMBERS.add(j);
            }
        }
    }

}
